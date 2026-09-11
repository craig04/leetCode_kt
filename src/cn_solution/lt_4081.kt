package cn_solution

class Solution_4081 {

    companion object {

        const val INF = Int.MAX_VALUE / 2
        val primes = ArrayList<Int>()

        init {
            val t = BooleanArray(1001) { true }
            for (i in 2 until t.size)
                if (t[i]) {
                    primes += i
                    for (j in i * i until t.size step i)
                        t[j] = false
                }
        }
    }

    fun maxPrimeSubset(n: Int, s: Int): List<Int> {
        var pos = primes.binarySearch(n + 1)
        if (pos < 0)
            pos = pos.inv()
        val dp = Array(pos + 1) { IntArray(s + 1) { INF } }
        dp[pos][0] = 0
        for (i in pos - 1 downTo 0) {
            val p = primes[i]
            for (j in 0..s)
                dp[i][j] = if (j >= p)
                    minOf(dp[i + 1][j], dp[i + 1][j - p] + 1)
                else
                    dp[i + 1][j]
        }
        val ans = ArrayList<Int>()
        var i = 0
        var j = (s downTo 0).first { dp[0][it] != INF }
        while (j != 0) {
            val p = primes[i++]
            if (dp[i][j - p] + 1 == dp[i - 1][j]) {
                ans += p
                j -= p
            }
        }
        return ans
    }
}