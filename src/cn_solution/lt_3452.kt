package cn_solution

fun sumOfGoodNumbers(nums: IntArray, k: Int): Int {
    val n = nums.size
    var ans = 0
    for (i in nums.indices) {
        val num = nums[i]
        if (i >= k && num <= nums[i - k] || i < n - k && num <= nums[i + k])
            continue
        ans += num
    }
    return ans
}