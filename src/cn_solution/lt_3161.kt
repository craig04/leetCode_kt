package cn_solution

import java.util.*

fun getResults(queries: Array<IntArray>): List<Boolean> {
    var max = 0
    var cnt = queries.size
    val pos = arrayListOf(0)
    for ((type, x) in queries)
        if (type == 1) {
            max = maxOf(max, x)
            cnt--
            pos += x
        }
    pos.sort()
    val map = TreeMap<Int, Int>()
    map[0] = 0
    val a = IntArray(max + 1)
    fun update(i: Int, x: Int) {
        var j = i
        while (j <= max) {
            a[j] = maxOf(a[j], x)
            j += j and -j
        }
    }

    fun query(i: Int): Int {
        var res = 0
        var j = i
        while (j > 0) {
            res = maxOf(res, a[j])
            j = j and (j - 1)
        }
        return res
    }
    for (i in 1 until pos.size) {
        val x = pos[i]
        map[x] = x - pos[i - 1]
        update(x, x - pos[i - 1])
    }
    val ans = BooleanArray(cnt)
    for (i in queries.indices.reversed()) {
        val (type, x) = queries[i]
        if (type == 1) {
            val e = map.higherEntry(x)
            val dis = map.remove(x) ?: 0
            if (e != null)
                update(e.key, map.merge(e.key, dis, Int::plus) ?: 0)
        } else {
            val pre = map.floorKey(x)
            ans[--cnt] = maxOf(x - pre, query(pre)) >= queries[i][2]
        }
    }
    return ans.asList()
}