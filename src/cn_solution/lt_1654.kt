package cn_solution

import kotlin.math.absoluteValue

fun minimumJumps(forbidden: IntArray, a: Int, b: Int, x: Int): Int {
    val visit = hashMapOf(0 to 0)
    forbidden.forEach {
        visit[it] = 0
        visit[-it] = 0
    }
    val q = ArrayDeque<Int>()
    q.add(0)
    val upper = when {
        a < b -> maxOf(forbidden.max() + a + b, x)
        a > b -> x + b
        else -> x
    }
    while (q.isNotEmpty()) {
        val vector = q.removeFirst()
        val pos = vector.absoluteValue
        val step = visit[vector] ?: 0
        if (pos == x)
            return step
        val right = pos + a
        if (right <= upper && visit.putIfAbsent(right, step + 1) == null)
            q.addLast(right)
        if (vector >= 0) {
            val left = pos - b
            if (left >= 0 && visit.putIfAbsent(-left, step + 1) == null)
                q.addLast(-left)
        }
    }
    return -1
}