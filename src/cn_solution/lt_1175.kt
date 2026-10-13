package cn_solution

class Solution_1175 {

    companion object {

        const val MAX = 100
        val ans = IntArray(MAX + 1)

        init {
            val modulo = 1000000007
            val a = LongArray(MAX + 1)
            val p = BooleanArray(MAX + 1) { true }
            var cnt = 0
            a[0] = 1
            p[1] = false
            for (i in 1..MAX) {
                if (p[i]) {
                    cnt++
                    for (j in i * i..MAX step i)
                        p[j] = false
                }
                a[i] = a[i - 1] * i % modulo
                ans[i] = a[cnt].times(a[i - cnt]).mod(modulo)
            }
        }
    }

    fun numPrimeArrangements(n: Int): Int {
        return ans[n]
    }
}