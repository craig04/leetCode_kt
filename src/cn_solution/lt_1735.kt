package cn_solution

class Solution_1735 {

    companion object {

        const val MOD = 1000000007
        val c = Array(10013) { IntArray(14) }

        init {
            for (i in c.indices) {
                c[i][0] = 1
                for (j in 1..minOf(i, 13))
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD
            }
        }
    }

    fun waysToFillArray(queries: Array<IntArray>): IntArray {
        return IntArray(queries.size) {
            var (n, k) = queries[it]
            var i = 2
            var ans = 1L
            while (i * i <= k) {
                var cnt = 0
                while (k % i == 0) {
                    k /= i
                    cnt++
                }
                if (cnt != 0)
                    ans = (ans * c[n + cnt - 1][cnt]) % MOD
                i++
            }
            if (k != 1)
                ans = (ans * n) % MOD
            ans.mod(MOD)
        }
    }
}