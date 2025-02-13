package cn_solution

class Solution_3463 {

    companion object {

        private const val MOD = 10
        private const val N = 100000
        private val f = IntArray(N + 1)
        private val g = IntArray(N + 1)
        private val c2 = IntArray(N + 1)
        private val c5 = IntArray(N + 1)

        init {
            f[0] = 1
            for (i in 1..N) {
                c2[i] = i.countTrailingZeroBits()
                var j = i shr c2[i]
                while (j % 5 == 0) {
                    j /= 5
                    c5[i]++
                }
                f[i] = f[i - 1] * j % MOD
                c2[i] += c2[i - 1]
                c5[i] += c5[i - 1]
            }
            g[N] = pow(f[N], 3)
            for (i in N downTo 1) {
                var j = i shr i.countTrailingZeroBits()
                while (j % 5 == 0)
                    j /= 5
                g[i - 1] = g[i] * j % MOD
            }
        }

        fun pow(x: Int, n: Int): Int {
            var ans = 1
            var y = x
            var m = n
            while (m != 0) {
                if (m and 1 == 1)
                    ans = ans * y % MOD
                y = y * y % MOD
                m = m shr 1
            }
            return ans
        }

        fun comb(n: Int, k: Int): Int {
            return f[n] * g[k] * g[n - k] *
                    pow(2, c2[n] - c2[k] - c2[n - k]) *
                    pow(5, c5[n] - c5[k] - c5[n - k]) % MOD
        }
    }

    fun hasSameDigits(s: String): Boolean {
        val n = s.length
        return (1 until s.length).sumOf {
            comb(n - 2, it - 1) * (s[it - 1] - s[it])
        } % MOD == 0
    }
}