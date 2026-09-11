package cn_solution

class Solution_1621 {

    companion object {
        const val N = 1999
        const val MOD = 1000000007
        val fac = LongArray(N)
        val inv = LongArray(N)

        init {
            fac[0] = 1
            for (i in 1 until N)
                fac[i] = fac[i - 1] * i % MOD
            var pow = MOD - 2
            var mul = fac[N - 1]
            var res = 1L
            while (pow != 0) {
                if (pow and 1 == 1)
                    res = res * mul % MOD
                pow = pow shr 1
                mul = mul * mul % MOD
            }
            inv[N - 1] = res
            for (i in N - 1 downTo 1)
                inv[i - 1] = inv[i] * i % MOD
        }
    }

    fun numberOfSets_combinatorics(n: Int, k: Int): Int {
        return (fac[n + k - 1] * inv[2 * k] % MOD * inv[n - k - 1]).mod(MOD)
    }
}

fun numberOfSets_dynamicProgramming(n: Int, k: Int): Int {
    val modulo = 1000000007
    val dp = IntArray(n + 1) { it }
    repeat(k) {
        var pre = 0
        for (i in 1..n) {
            val cur = (dp[i] + pre) % modulo
            dp[i] = (dp[i - 1] + pre) % modulo
            pre = cur
        }
    }
    return (dp[n] - dp[n - 1] + modulo) % modulo
}