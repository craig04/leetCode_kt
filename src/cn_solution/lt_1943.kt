package cn_solution

fun splitPainting(segments: Array<IntArray>): List<List<Long>> {
    val map = HashMap<Int, Long>()
    for ((s, e, c) in segments) {
        val x = c.toLong()
        map.merge(s, x) { a, b -> a + b }
        map.merge(e, -x) { a, b -> a + b }
    }
    val iterator = map.iterator()
    val a = Array(map.size) {
        val (k, v) = iterator.next()
        longArrayOf(k.toLong(), v)
    }
    a.sortBy { it[0] }
    val ans = ArrayList<List<Long>>()
    var cur = a[0][1]
    for (i in 1 until a.size) {
        if (cur != 0L)
            ans.add(listOf(a[i - 1][0], a[i][0], cur))
        cur += a[i][1]
    }
    return ans
}