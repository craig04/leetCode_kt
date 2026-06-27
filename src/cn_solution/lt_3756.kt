package cn_solution

class Solution_3756 {

    companion object {

        const val MOD = 1000000007
        val pow = IntArray(100001)

        init {
            pow[0] = 1
            for (i in 1 until pow.size)
                pow[i] = (pow[i - 1] * 10L).mod(MOD)
        }
    }

    fun sumAndMultiply(s: String, queries: Array<IntArray>): IntArray {
        val n = s.length
        val sum = IntArray(n + 1)
        val num = IntArray(n + 1)
        val cnt = IntArray(n + 1)
        for (i in s.indices) {
            val d = s[i] - '0'
            sum[i + 1] = sum[i] + d
            num[i + 1] = num[i]
            cnt[i + 1] = cnt[i]
            if (s[i] != '0') {
                num[i + 1] = (num[i] * 10L + d).mod(MOD)
                cnt[i + 1]++
            }
        }
        return IntArray(queries.size) {
            var (l, r) = queries[it]
            val len = cnt[++r] - cnt[l]
            val s = num[r] - (1L * num[l] * pow[len] % MOD) + MOD
            (s * (sum[r] - sum[l])).mod(MOD)
        }
    }
}