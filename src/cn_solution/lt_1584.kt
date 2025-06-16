package cn_solution

import kotlin.math.abs

fun minCostConnectPoints(points: Array<IntArray>): Int {
    fun dist(x: Int, y: Int) =
        abs(points[x][0] - points[y][0]) + abs(points[x][1] - points[y][1])

    val n = points.size
    val vis = BooleanArray(n)
    vis[0] = true
    val dist = IntArray(n) { dist(0, it) }
    var ans = 0
    repeat(n - 1) {
        var idx = -1
        var cost = Int.MAX_VALUE
        for (i in 0 until n)
            if (!vis[i] && dist[i] < cost) {
                idx = i
                cost = dist[i]
            }
        ans += cost
        vis[idx] = true
        for (i in 0 until n)
            if (!vis[i])
                dist[i] = minOf(dist[i], dist(idx, i))
    }
    return ans
}