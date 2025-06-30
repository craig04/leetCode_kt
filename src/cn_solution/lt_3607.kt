package cn_solution

import java.util.*

fun processQueries(c: Int, connections: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val p = IntArray(c + 1) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    for ((x, y) in connections)
        p[find(x)] = find(y)
    val map = HashMap<Int, TreeSet<Int>>()
    for (i in 1..c)
        map.computeIfAbsent(find(i)) { TreeSet() }.add(i)
    val ans = ArrayList<Int>()
    for ((type, x) in queries) {
        val set = map[find(x)] ?: continue
        if (type == 1) {
            ans.add(
                when {
                    set.isEmpty() -> -1
                    x in set -> x
                    else -> set.first()
                }
            )
        } else {
            set.remove(x)
        }
    }
    return ans.toIntArray()
}