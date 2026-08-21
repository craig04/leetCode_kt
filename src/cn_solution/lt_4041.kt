package cn_solution

private fun minOperations(nums: IntArray, sum: Int): Int {
    val dp = IntArray(sum + 1) { Int.MAX_VALUE / 2 }
    dp[0] = 0
    for (num in nums) {
        for (i in sum downTo 1) {
            var a = 0
            while (num shr a > 0) {
                var b = 0
                while (true) {
                    val x = num shr a shl b
                    if (x > i)
                        break
                    dp[i] = minOf(dp[i], dp[i - x] + a + b++)
                }
                a++
            }
        }
    }
    return if (dp[sum] == Int.MAX_VALUE / 2) -1 else dp[sum]
}