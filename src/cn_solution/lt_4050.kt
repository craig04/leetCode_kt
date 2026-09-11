package cn_solution

class Solution_4050 {

    companion object {
        val dp = IntArray(100001) { Int.MAX_VALUE / 2 }

        init {
            dp[0] = -1
            var d = 1
            var s = 1
            while (s < dp.size) {
                for (i in s until dp.size)
                    dp[i] = minOf(dp[i], dp[i - s] + d + 1)
                s += ++d
            }
        }
    }

    fun minDays(n: Int): Int {
        return dp[n]
    }
}