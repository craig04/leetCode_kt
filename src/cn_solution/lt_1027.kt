package cn_solution

fun longestArithSeqLength(nums: IntArray): Int {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (n in nums) {
        min = minOf(min, n)
        max = maxOf(max, n)
    }
    val diff = max - min
    var result = 0
    val dp = IntArray(max + 1)
    for (delta in -diff..diff) {
        dp.fill(0)
        for (n in nums) {
            val prev = n - delta
            if (prev in (min..max)) {
                dp[n] = maxOf(dp[n], dp[prev] + 1)
            }
            dp[n] = maxOf(dp[n], 1)
            result = maxOf(result, dp[n])
        }
    }
    return result
}