package cn_solution

fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {

    class Topological(size: Int) {

        val after = Array(size) { ArrayList<Int>() }
        val degree = IntArray(size)
        fun add(u: Int, v: Int) {
            after[u].add(v)
            degree[v]++
        }

        fun sort(list: Iterable<Int>): List<Int> {
            val ans = ArrayList<Int>()
            val q = list.filterTo(ArrayDeque()) { degree[it] == 0 }
            while (q.isNotEmpty()) {
                val u = q.removeFirst()
                ans.add(u)
                for (v in after[u])
                    if (--degree[v] == 0)
                        q.add(v)
            }
            return ans
        }
    }

    val todo = Array(n + m) { ArrayList<Int>() }
    var size = m
    for (i in 0 until n) {
        if (group[i] == -1)
            group[i] = size++
        todo[group[i]].add(i)
    }

    val g = Topological(size)
    val p = Topological(n)
    for (v in beforeItems.indices) {
        val y = group[v]
        for (u in beforeItems[v]) {
            val x = group[u]
            if (x == y)
                p.add(u, v)
            else
                g.add(x, y)
        }
    }
    val groups = g.sort(0 until size)
    if (groups.size != size)
        return intArrayOf()
    return groups.flatMap {
        val items = p.sort(todo[it])
        if (items.size != todo[it].size)
            return intArrayOf()
        items
    }.toIntArray()
}