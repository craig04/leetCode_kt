package cn_solution

fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {
    val g = Array(n + 1) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u] += v
        g[v] += u
    }
    val dis = Array(2) { IntArray(n + 1) { Int.MAX_VALUE } }
    dis[0][1] = 0
    val q = ArrayDeque<IntArray>()
    q.addLast(intArrayOf(0, 1))
    while (q.isNotEmpty() && dis[1][n] == Int.MAX_VALUE) {
        val (t, u) = q.removeFirst()
        for (v in g[u]) {
            val s = when {
                dis[0][v] == Int.MAX_VALUE -> 0
                dis[0][v] == dis[t][u] + 1 -> continue
                dis[1][v] == Int.MAX_VALUE -> 1
                else -> continue
            }
            dis[s][v] = dis[t][u] + 1
            q.addLast(intArrayOf(s, v))
        }
    }
    var ans = 0
    repeat(dis[1][n]) {
        if (ans / change % 2 == 1)
            ans = (ans / (change * 2) + 1) * change * 2
        ans += time
    }
    return ans
}