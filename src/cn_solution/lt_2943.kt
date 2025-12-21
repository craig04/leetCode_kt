package cn_solution

fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {
    fun IntArray.consecutive(): Int {
        val set = toHashSet()
        return set.maxOf {
            if (it - 1 in set)
                return@maxOf 0
            var len = 1
            while (it + len in set)
                len++
            len
        } + 1
    }

    val len = minOf(hBars.consecutive(), vBars.consecutive())
    return len * len
}