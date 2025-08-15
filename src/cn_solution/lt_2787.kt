package cn_solution

class Solution_2787 {

    companion object {

        val dp = Array(6) { IntArray(301) }

        init {
            dp.forEach { it[0] = 1 }
            for (num in 1..300) {
                var pow = 1
                for (i in 1..5) {
                    pow *= num
                    if (pow > 300)
                        break
                    for (j in 300 downTo pow)
                        dp[i][j] = (dp[i][j] + dp[i][j - pow]) % 1000000007
                }
            }
        }
    }

    fun numberOfWays(n: Int, x: Int): Int {
        return dp[x][n]
    }
}