package cn_lcp

import java.util.*
import kotlin.collections.ArrayDeque

fun challengeOfTheKeeper_dijkstra(maze: Array<String>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = maze.size
    val side = 0 until n
    var (sx, sy, tx, ty) = IntArray(4)
    for (i in side)
        for (j in side)
            if (maze[i][j] == 'S') {
                sx = i
                sy = j
            } else if (maze[i][j] == 'T') {
                tx = i
                ty = j
            }
    val q = ArrayDeque<IntArray>()
    val dist = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    q.addLast(intArrayOf(tx, ty))
    dist[tx][ty] = 0
    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        for (i in d.indices.step(2)) {
            val u = x + d[i]
            val v = y + d[i + 1]
            if (u in side && v in side && maze[u][v] != '#' && dist[u][v] == Int.MAX_VALUE) {
                dist[u][v] = dist[x][y] + 1
                q.addLast(intArrayOf(u, v))
            }
        }
    }
    if (dist[sx][sy] == Int.MAX_VALUE)
        return -1
    val cost = Array(n) { IntArray(n) }
    for (i in side)
        for (j in side)
            if (maze[i][j] == '.') {
                val x = n - 1 - i
                if (maze[x][j] != '#')
                    cost[i][j] = maxOf(cost[i][j], dist[x][j])
                val y = n - 1 - j
                if (maze[i][y] != '#')
                    cost[i][j] = maxOf(cost[i][j], dist[i][y])
            }
    dist.forEach { println(it.asList()) }
    cost.forEach { println(it.asList()) }
    val dp = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val pq = PriorityQueue<IntArray> { a, b -> a[0] - b[0] }
    dp[sx][sy] = 0
    pq.add(intArrayOf(0, sx, sy))
    while (pq.isNotEmpty()) {
        val (c, x, y) = pq.remove()
        if (dp[x][y] != c)
            continue
        for (i in d.indices.step(2)) {
            val u = x + d[i]
            val v = y + d[i + 1]
            if (u == tx && v == ty)
                return c
            if (u in side && v in side && maze[u][v] == '.' && maxOf(c, cost[u][v]) < dp[u][v]) {
                dp[u][v] = maxOf(c, cost[u][v])
                pq.add(intArrayOf(dp[u][v], u, v))
            }
        }
    }
    return -1
}

fun challengeOfTheKeeper_bisect(maze: Array<String>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = maze.size
    val side = 0 until n
    var (sx, sy, tx, ty) = IntArray(4)
    for (i in side)
        for (j in side)
            if (maze[i][j] == 'S') {
                sx = i
                sy = j
            } else if (maze[i][j] == 'T') {
                tx = i
                ty = j
            }
    val q = ArrayDeque<IntArray>()
    val dist = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    q.addLast(intArrayOf(tx, ty))
    dist[tx][ty] = 0
    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        for (i in d.indices.step(2)) {
            val u = x + d[i]
            val v = y + d[i + 1]
            if (u in side && v in side && maze[u][v] != '#' && dist[u][v] == Int.MAX_VALUE) {
                dist[u][v] = dist[x][y] + 1
                q.addLast(intArrayOf(u, v))
            }
        }
    }
    if (dist[sx][sy] == Int.MAX_VALUE)
        return -1
    val vis = Array(n) { IntArray(n) { -1 } }
    var l = 0
    var r = n * n
    bisect@ while (l < r) {
        val m = (l + r) shr 1
        vis[sx][sy] = m
        q.clear()
        q.addLast(intArrayOf(sx, sy))
        while (q.isNotEmpty()) {
            val (x, y) = q.removeFirst()
            for (i in d.indices.step(2)) {
                val u = x + d[i]
                val v = y + d[i + 1]
                if (u !in side || v !in side || maze[u][v] == '#' || vis[u][v] == m)
                    continue
                if (maze[u][v] == 'T') {
                    r = m
                    continue@bisect
                }
                val a = n - 1 - u
                if (maze[a][v] != '#' && dist[a][v] > m)
                    continue
                val b = n - 1 - v
                if (maze[u][b] != '#' && dist[u][b] > m)
                    continue
                vis[u][v] = m
                q.addLast(intArrayOf(u, v))
            }
        }
        l = m + 1
    }
    return if (l == n * n) -1 else l
}