package cn_lcr

fun permuteUnique(nums: IntArray): List<List<Int>> {
    fun swap(i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }

    fun hasNext(): Boolean {
        var i = nums.lastIndex
        while (i != 0 && nums[i] <= nums[i - 1])
            i--
        if (--i < 0)
            return false
        var j = nums.lastIndex
        while (j != i && nums[j] <= nums[i])
            j--
        swap(i++, j)
        j = nums.lastIndex
        while (i < j)
            swap(i++, j--)
        return true
    }
    nums.sort()
    val result = ArrayList<List<Int>>()
    do {
        result.add(nums.toList())
    } while (hasNext())
    return result
}