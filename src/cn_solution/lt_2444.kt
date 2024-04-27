package cn_solution

fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
    var min = -1
    var max = -1
    var bound = 0
    return nums.indices.sumOf {
        if (nums[it] == minK)
            min = it
        if (nums[it] == maxK)
            max = it
        if (nums[it] !in minK..maxK)
            bound = it + 1
        if (min != -1 && max != -1)
            maxOf(0L, minOf(min, max) - bound + 1L)
        else
            0L
    }
}
