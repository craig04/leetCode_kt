package cn_solution

class Solution_4002 {

    companion object {
        const val N = 500000
        const val MOD = 1000000007
        val fac = LongArray(N)
        val inv = LongArray(N)

        init {
            fac[0] = 1
            for (i in 1 until N)
                fac[i] = fac[i - 1] * i % MOD
            inv[N - 1] = 1
            var t = MOD - 2
            var y = fac[N - 1]
            while (t != 0) {
                if (t and 1 == 1)
                    inv[N - 1] = (inv[N - 1] * y) % MOD
                y = y * y % MOD
                t = t shr 1
            }
            for (i in N - 1 downTo 1)
                inv[i - 1] = inv[i] * i % MOD
        }
    }

    fun countValidSequences(n: Int, k: Int): Int {
        var ans = fac[n - 1] * inv[k - 1] % MOD * inv[n - k] % MOD
        if ((n + k) % 2 == 0) {
            val t = (n + k) / 2 - 1
            val sub = fac[t] * inv[k - 1] % MOD * inv[t - k + 1] % MOD
            ans = (ans - sub + MOD) % MOD
        }
        return ans.mod(MOD)
    }
}