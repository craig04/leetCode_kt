package cn_solution

import java.util.*

fun minOperations(n: Int, m: Int): Int {
    val p = BooleanArray(10000) { true }
    for (i in 2 until p.size)
        if (p[i])
            for (j in i * 2 until p.size step i)
                p[j] = false
    p[1] = false
    if (p[n] || p[m])
        return -1
    val dist = IntArray(10000) { Int.MAX_VALUE }
    val q = PriorityQueue<IntArray> { a, b -> a[0] - b[0] }
    dist[n] = n
    q.offer(intArrayOf(n, n))
    while (q.isNotEmpty()) {
        val (d, u) = q.poll()
        if (u == m)
            return d
        if (d > dist[u])
            continue
        var x = 1
        while (x <= u) {
            fun test(v: Int) {
                if (!p[v] && dist[v] >= d + v) {
                    dist[v] = d + v
                    q.offer(intArrayOf(dist[v], v))
                }
            }

            val y = u / x % 10
            if (y > 0)
                test(u - x)
            if (y < 9)
                test(u + x)
            x *= 10
        }
    }
    return -1
}