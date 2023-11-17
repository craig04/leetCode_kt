package cn_lcr

class Solution(w: IntArray) {

    private val percent: DoubleArray

    init {
        val sum = w.sum()
        var temp = 0
        percent = DoubleArray(w.size)
        w.forEachIndexed { index, n ->
            temp += n
            percent[index] = temp.toDouble() / sum
        }
    }

    fun pickIndex(): Int {
        var l = 0
        var r = percent.lastIndex
        val random = Math.random()
        while (l != r) {
            val m = (l + r) shr 1
            when (percent[m] < random) {
                true -> l = m + 1
                else -> r = m
            }
        }
        return r
    }
}