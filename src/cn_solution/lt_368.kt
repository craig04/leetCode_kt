package cn_solution

fun largestDivisibleSubset(nums: IntArray): List<Int> {
    nums.sort()
    var pivot = 0
    val dp = IntArray(nums.size)
    val prev = IntArray(nums.size) { it }
    for (i in nums.indices) {
        for (j in 0 until i) {
            if (nums[i] % nums[j] == 0 && dp[j] >= dp[i]) {
                dp[i] = dp[j] + 1
                prev[i] = j
            }
        }
        if (dp[i] > dp[pivot]) {
            pivot = i
        }
    }
    val result = arrayListOf(nums[pivot])
    while (prev[pivot] != pivot) {
        pivot = prev[pivot]
        result.add(nums[pivot])
    }
    return result
}