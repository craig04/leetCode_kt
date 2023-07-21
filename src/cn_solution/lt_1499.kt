package cn_solution

import java.util.PriorityQueue

fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
    val q = PriorityQueue<Int> { lhs, rhs ->
        val (lx, ly) = points[lhs]
        val (rx, ry) = points[rhs]
        lx - ly - rx + ry
    }
    var result = Int.MIN_VALUE
    points.forEachIndexed { i, (x, y) ->
        while (q.isNotEmpty()) {
            val (u, v) = points[q.peek()]
            if (x - u <= k) {
                result = maxOf(result, x - u + y + v)
                break
            }
            q.poll()
        }
        q.offer(i)
    }
    return result
}