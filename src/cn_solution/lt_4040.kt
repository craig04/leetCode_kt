package cn_solution

private fun minOperations(nums: IntArray, sum: Int): Int {
    val dp = IntArray(sum + 1) { Int.MAX_VALUE / 2 }
    dp[0] = 0
    for (num in nums) {
        for (i in sum downTo 1) {
            var x = num
            var t = 0
            while (x <= i) {
                dp[i] = minOf(dp[i], dp[i - x] + t)
                x *= 2
                t++
            }
            x = num / 2
            t = 1
            while (x > 0) {
                if (x <= i)
                    dp[i] = minOf(dp[i], dp[i - x] + t)
                x /= 2
                t++
            }
        }
    }
    return if (dp[sum] >= Int.MAX_VALUE / 2) -1 else dp[sum]
}