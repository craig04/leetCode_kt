package cn_solution

class Solution_3770 {

    companion object {

        const val MAX = 500000
        val ans = IntArray(MAX + 1)

        init {
            val f = BooleanArray(MAX + 1) { true }
            var p = ArrayList<Int>()
            for (i in 2..MAX)
                if (f[i]) {
                    p.add(i)
                    if (MAX / i >= i)
                        for (j in i * i..MAX step i)
                            f[j] = false
                }
            var pre = 0
            var sum = 0
            var j = 0
            for (i in 2..MAX) {
                if (sum + p[j] == i) {
                    sum += p[j++]
                    if (f[sum])
                        pre = sum
                }
                ans[i] = pre
            }
        }
    }

    fun largestPrime(n: Int): Int = ans[n]
}