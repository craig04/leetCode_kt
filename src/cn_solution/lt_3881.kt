package cn_solution

class Solution_3881 {

    companion object {

        const val N = 100000
        const val MOD = 1000000007
        val fac = LongArray(N)
        val inv = LongArray(N)

        init {
            fac[0] = 1
            for (i in 1 until N)
                fac[i] = fac[i - 1] * i % MOD

            inv[N - 1] = 1
            var b = N - 1L
            var t = MOD - 2
            while (t > 0) {
                if (t and 1 == 1)
                    inv[N - 1] = inv[N - 1] * b % MOD
                b = b * b % MOD
                t = t shr 1
            }
            for (i in N - 1 downTo 1)
                inv[i - 1] = inv[i] * i % MOD
        }
    }

    fun countVisiblePeople(n: Int, pos: Int, k: Int): Int {
        val ans = fac[n - 1] * inv[k] % MOD * inv[n - 1 - k] % MOD
        return (2 * ans).mod(MOD)
    }
}