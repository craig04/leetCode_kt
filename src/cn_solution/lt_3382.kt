package cn_solution

fun maxRectangleArea(xCoord: IntArray, yCoord: IntArray): Long {
    val sorted = yCoord.toHashSet().toIntArray()
    sorted.sort()
    val map = sorted.indices.associateByTo(HashMap()) { sorted[it] }
    val col = HashMap<Int, ArrayList<Int>>()
    xCoord.forEachIndexed { i, x ->
        col.getOrPut(x) { ArrayList() }.add(map[yCoord[i]]!!)
    }
    val side = HashMap<Long, Pair<Int, Int>>()
    val a = IntArray(sorted.size + 1)
    fun query(x: Int): Int {
        var t = x
        var ans = 0
        while (t > 0) {
            ans += a[t]
            t -= t.takeLowestOneBit()
        }
        return ans
    }

    fun add(x: Int) {
        var t = x
        do {
            a[t]++
            t += t.takeLowestOneBit()
        } while (t < a.size)
    }

    var ans = -1L
    for ((x2, list) in col.entries.sortedBy { it.key }) {
        list.sort()
        for (i in 1 until list.size) {
            val y1 = list[i - 1]
            val y2 = list[i]
            val cur = query(y2 + 1) - query(y1)
            side.put(y1 * 100000000L + y2, Pair(cur, x2))?.let { (pre, x1) ->
                if (cur - pre == 2)
                    ans = maxOf(ans, (x2 - x1) * 1L * (sorted[y2] - sorted[y1]))
            }
        }
        list.forEach { add(it + 1) }
    }
    return ans
}