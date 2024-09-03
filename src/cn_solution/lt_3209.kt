package cn_solution

private fun countSubarrays(nums: IntArray, k: Int): Long {
    var cnt = 0L
    return nums.indices.sumOf { i ->
        if (nums[i] == k)
            cnt++
        for (j in i - 1 downTo 0) {
            if (nums[j] == k)
                cnt--
            val t = nums[j] and nums[i]
            if (t == k)
                cnt++
            if (t == nums[j])
                break
            nums[j] = t
        }
        cnt
    }
}