package cn_solution

fun permute(nums: IntArray): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    fun nextPermutation(): Boolean {
        val p = (nums.lastIndex downTo 1).firstOrNull {
            nums[it - 1] < nums[it]
        } ?: return false
        val q = (nums.lastIndex downTo p).first {
            nums[it] > nums[p - 1]
        }
        val tmp = nums[p - 1]
        nums[p - 1] = nums[q]
        nums[q] = tmp
        nums.sort(p)
        return true
    }
    nums.sort()
    do {
        result.add(nums.toList())
    } while (nextPermutation())
    return result
}