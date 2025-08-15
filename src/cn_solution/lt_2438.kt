package cn_solution

class Solution_2438 {

    companion object {

        const val MOD = 1000000007
        val pow = IntArray(436)

        init {
            pow[0] = 1
            for (i in 1 until pow.size)
                pow[i] = (pow[i - 1] * 2) % MOD
        }
    }

    fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
        val pre = arrayListOf(0)
        var m = n
        while (m != 0) {
            pre.add(pre.last() + m.countTrailingZeroBits())
            m = m and (m - 1)
        }
        return IntArray(queries.size) {
            pow[pre[queries[it][1] + 1] - pre[queries[it][0]]]
        }
    }
}