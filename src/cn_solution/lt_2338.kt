package cn_solution

class Solution_2338 {

    companion object {

        const val MOD = 1000000007
        const val N = 10001
        const val M = 16
        val cnt = Array(N) { ArrayList<Int>() }
        val comb = Array(N + M) { IntArray(M) }

        init {
            val f = BooleanArray(N)
            for (i in 2 until N) {
                if (f[i])
                    continue
                for (j in i until N step i) {
                    f[j] = true
                    var x = j
                    var t = 0
                    while (x % i == 0) {
                        x /= i
                        t++
                    }
                    cnt[j].add(t)
                }
            }
            for (i in comb.indices) {
                comb[i][0] = 1
                for (j in 1..minOf(M - 1, i))
                    comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD
            }
        }
    }

    fun idealArrays(n: Int, maxValue: Int): Int {
        return (1..maxValue).sumOf { end ->
            cnt[end].fold(1L) { acc, y ->
                acc * comb[n - 1 + y][y] % MOD
            }
        }.mod(MOD)
    }
}