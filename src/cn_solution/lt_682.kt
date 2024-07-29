package cn_solution

import java.util.*

fun calPoints(operations: Array<String>): Int {
    val s = ArrayList<Int>()
    for (op in operations) {
        when (op) {
            "+" -> s.add(s.last() + s[s.lastIndex - 1])
            "D" -> s.add(s.last() * 2)
            "C" -> s.removeLast()
            else -> s.add(op.toInt())
        }
    }
    return s.sum()
}