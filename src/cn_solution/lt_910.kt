package cn_solution

fun smallestRangeII(nums: IntArray, k: Int): Int {
    nums.sort()
    val n = nums.size
    var ans = nums[n - 1] - nums[0]
    for (i in 0 until n - 1) {
        val min = minOf(nums[0] + k, nums[i + 1] - k)
        val max = maxOf(nums[i] + k, nums[n - 1] - k)
        ans = minOf(ans, max - min)
    }
    return ans
}