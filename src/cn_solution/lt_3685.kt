package cn_solution

fun subsequenceSumAfterCapping(nums: IntArray, k: Int): BooleanArray {
    val n = nums.size
    val cnt = IntArray(n + 1)
    for (num in nums)
        cnt[num]++
    val dp = BooleanArray(k + 1)
    dp[0] = true
    var remain = n
    return BooleanArray(n) { i ->
        repeat(cnt[i]) {
            for (j in k downTo i)
                dp[j] = dp[j] || dp[j - i]
        }
        remain -= cnt[i]
        val x = i + 1
        val max = minOf(remain, k / x)
        (0..max).any { dp[k - it * x] }
    }
}