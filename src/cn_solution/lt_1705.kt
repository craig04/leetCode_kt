package cn_solution

import java.util.*

fun eatenApples(apples: IntArray, days: IntArray): Int {
    val q = PriorityQueue<IntArray> { l, r -> l[0] - r[0] }
    var ans = 0
    for (i in apples.indices) {
        while (q.isNotEmpty() && q.peek()[0] <= i)
            q.poll()
        if (apples[i] != 0)
            q.offer(intArrayOf(i + days[i], apples[i]))
        if (q.isNotEmpty()) {
            if (--q.peek()[1] == 0)
                q.poll()
            ans++
        }
    }
    var cur = apples.size
    while (q.isNotEmpty()) {
        val a = q.poll()
        if (a[0] < cur)
            continue
        val eat = minOf(a[1], a[0] - cur)
        ans += eat
        cur += eat
    }
    return ans
}