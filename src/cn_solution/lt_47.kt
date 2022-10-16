package cn_solution

fun permuteUnique(nums: IntArray): List<List<Int>> {
    fun swap(i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }

    fun hasNext(): Boolean {
        var last = nums.lastIndex
        val i = (last - 1 downTo 0).firstOrNull { nums[it] < nums[it + 1] } ?: return false
        val j = (last downTo i + 1).firstOrNull { nums[it] > nums[i] } ?: return false
        swap(i, j)
        var first = i + 1
        while (first < last) swap(first++, last--)
        return true
    }
    nums.sort()
    val result = ArrayList<List<Int>>()
    do {
        result.add(nums.toList())
    } while (hasNext())
    return result
}
