package cn_lcr

import kotlin.math.sign

fun openLock(deadends: Array<String>, target: String): Int {
    val t = target.toInt()
    val s = deadends.mapTo(HashSet()) { it.toInt() }
    if (!s.add(0))
        return -1
    val q = ArrayDeque<Int>()
    q.add(0)
    var step = 0
    val base = intArrayOf(1, 10, 100, 1000)
    while (q.isNotEmpty()) {
        repeat(q.size) {
            val l = q.removeFirst()
            if (l == t)
                return step
            for (b in base) {
                val d = l / b % 10
                val upper = l + ((9 - d).sign * 10 - 9) * b
                if (s.add(upper))
                    q.addLast(upper)
                val lower = l - (d.sign * 10 - 9) * b
                if (s.add(lower))
                    q.addLast(lower)
            }
        }
        step++
    }
    return -1
}