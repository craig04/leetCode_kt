package cn_solution

import java.util.*

fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
    val set = HashSet<Int>()
    for ((l, r) in buildings) {
        set += l
        set += r
    }
    val boundaries = set.toMutableList().apply { sort() }
    val q = PriorityQueue<IntArray> { a, b -> b[2] - a[2] }
    var i = 0
    val ans = ArrayList<MutableList<Int>>()
    for (x in boundaries) {
        while (i != buildings.size && buildings[i][0] <= x)
            q.offer(buildings[i++])
        while (q.isNotEmpty() && q.peek()[1] <= x)
            q.poll()
        val y = q.peek()?.get(2) ?: 0
        if (ans.isEmpty() || ans.last()[1] != y)
            ans += arrayListOf(x, y)
        else
            ans.last()[1] = y
    }
    return ans
}