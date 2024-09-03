package cn_solution

private fun resultsArray(nums: IntArray, k: Int): IntArray {
    if (k == 1)
        return nums
    var cnt = 0
    for (i in 0 until k - 2)
        if (nums[i] + 1 != nums[i + 1])
            cnt++
    return IntArray(nums.size - k + 1) { i ->
        val j = i + k - 2
        if (nums[j] + 1 != nums[j + 1])
            cnt++
        val res = if (cnt == 0) nums[j + 1] else -1
        if (nums[i] + 1 != nums[i + 1])
            cnt--
        res
    }
}