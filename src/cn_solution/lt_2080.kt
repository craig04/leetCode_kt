package cn_solution

class RangeFreqQuery(arr: IntArray) {

    val pos = arr.indices.groupBy { arr[it] }

    fun query(left: Int, right: Int, value: Int): Int {
        val a = pos[value] ?: emptyList()
        return a.ceiling(right + 1) - a.ceiling(left)
    }

    private fun List<Int>.ceiling(x: Int): Int {
        var l = 0
        var r = size
        while (l != r) {
            val m = (l + r) / 2
            if (this[m] < x)
                l = m + 1
            else
                r = m
        }
        return l
    }
}