package cn_solution

import java.util.*

fun isPossible(target: IntArray): Boolean {
    if (target.size == 1)
        return target[0] == 1
    var sum = 0L
    val q = PriorityQueue<Int> { a, b -> b - a }
    for (t in target) {
        sum += t
        q.offer(t)
    }
    while (true) {
        val a = q.poll()
        if (a == 1)
            return true
        val dec = sum - a
        if (a <= dec)
            return false
        val b = q.peek()
        val sub = dec * if (b == 1)
            (a - b + dec - 1) / dec
        else
            (a - b + dec) / dec
        if (a <= sub)
            return false
        sum -= sub
        q.offer((a - sub).toInt())
    }
}