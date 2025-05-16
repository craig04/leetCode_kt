package cn_solution

private fun countSubarrays(nums: IntArray, k: Int): Long {
    val max = nums.max()
    var i = 0
    var cnt = 0
    return nums.indices.fold(0L) { ans, j ->
        if (nums[j] == max)
            cnt++
        while (cnt >= k)
            if (nums[i++] == max)
                cnt--
        ans + i
    }
}