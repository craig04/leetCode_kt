package cn_solution

fun countSubarrays(nums: IntArray, k: Long): Long {
    var sum = 0L
    var left = 0
    return nums.indices.sumOf { right ->
        sum += nums[right]
        while (sum * (right - left + 1) >= k)
            sum -= nums[left++]
        1L + right - left
    }
}