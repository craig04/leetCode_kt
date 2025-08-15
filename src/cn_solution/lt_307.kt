package cn_solution

class NumArray(val nums: IntArray) {

    val a = IntArray(nums.size + 1)

    init {
        nums.forEachIndexed(::updateDiff)
    }

    fun update(index: Int, `val`: Int) {
        val diff = `val` - nums[index]
        nums[index] = `val`
        updateDiff(index, diff)
    }

    private fun updateDiff(index: Int, diff: Int) {
        var x = index + 1
        while (x < a.size) {
            a[x] += diff
            x += x.takeLowestOneBit()
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return query(right) - query(left - 1)
    }

    private fun query(index: Int): Int {
        var x = index + 1
        var ans = 0
        while (x > 0) {
            ans += a[x]
            x = x and (x - 1)
        }
        return ans
    }
}