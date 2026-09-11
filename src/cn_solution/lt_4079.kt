package cn_solution

class Solution_4079 {

    companion object {
        const val MAX = 151057
        val num = ArrayList<Int>()
        val sum = ArrayList<Int>()

        init {
            val t = BooleanArray(MAX + 1) { true }
            for (i in 2..MAX) {
                if (t[i]) {
                    num += i
                    sum += i + (sum.lastOrNull() ?: 0)
                }
                if (MAX / i < i)
                    continue
                for (j in i * i..MAX step i)
                    t[j] = false
            }
        }
    }

    fun maxPrimes(n: Int, s: Int): List<Int> {
        var x = num.binarySearch(n + 1)
        if (x < 0)
            x = -x - 1
        var y = sum.binarySearch(s + 1)
        if (y < 0)
            y = -y - 1
        return num.take(minOf(x, y))
    }
}