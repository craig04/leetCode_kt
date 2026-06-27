package cn_solution

fun filterOccupiedIntervals(occupiedIntervals: Array<IntArray>, freeStart: Int, freeEnd: Int): List<List<Int>> {
    occupiedIntervals.sortBy { it[0] }
    val merge = arrayListOf(intArrayOf(-1, -1))
    for (interval in occupiedIntervals) {
        val (s, e) = interval
        val last = merge.last()
        if (s > last[1] + 1)
            merge.add(interval)
        else
            last[1] = maxOf(last[1], e)
    }
    val ans = ArrayList<List<Int>>()
    for (i in 1 until merge.size) {
        val (s, e) = merge[i]
        if (e < freeStart || s > freeEnd) {
            ans.add(listOf(s, e))
            continue
        }
        if (s < freeStart)
            ans.add(listOf(s, freeStart - 1))
        if (e > freeEnd)
            ans.add(listOf(freeEnd + 1, e))
    }
    return ans
}