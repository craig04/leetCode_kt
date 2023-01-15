package cn_solution

import java.util.*

fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
    class Class(var pass: Int = 0, var total: Int = 0, var increase: Double = 0.0) {
        fun set(p: Int, t: Int) {
            pass = p
            total = t
            increase = (p + 1.0) / (t + 1.0) - p.toDouble() / t
        }
    }

    val q = PriorityQueue<Class> { lhs, rhs -> rhs.increase.compareTo(lhs.increase) }
    classes.forEach { (p, t) -> q.add(Class().apply { set(p, t) }) }
    repeat(extraStudents) { q.add(q.poll().apply { set(pass + 1, total + 1) }) }
    return q.sumByDouble { it.pass.toDouble() / it.total } / q.size
}