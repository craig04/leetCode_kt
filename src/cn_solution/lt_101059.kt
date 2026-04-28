package cn_solution

class Solution_101059 {

    companion object {
        val sum = IntArray(1001) { it }

        init {
            sum[1] = 0
            for (i in 2 until sum.size) {
                if (sum[i] == i)
                    for (j in i * i until sum.size step i)
                        sum[j] = 0
                sum[i] += sum[i - 1]
            }
        }
    }

    fun sumOfPrimesInRange(n: Int): Int {
        var t = n
        var m = 0
        while (t != 0) {
            m = m * 10 + t % 10
            t /= 10
        }
        return sum[maxOf(m, n)] - sum[minOf(m, n) - 1]
    }
}