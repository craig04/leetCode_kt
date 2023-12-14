package cn_solution

import java.util.*

fun closestRoom(rooms: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val result = IntArray(queries.size)
    val indices = Array(queries.size) { it }
    indices.sortByDescending { queries[it][1] }
    rooms.sortByDescending { it[1] }
    val r = TreeSet<Int>()
    var j = 0
    for (i in indices.indices) {
        while (j != rooms.size && rooms[j][1] >= queries[i][1])
            r.add(rooms[j++][0])
        val pref = queries[i][0]
        var t = r.ceiling(pref) ?: Int.MAX_VALUE
        val lower = r.lower(pref)
        if (lower != null && t - pref >= pref - lower)
            t = lower
        result[i] = if (t == Int.MAX_VALUE) -1 else t
    }
    return result
}