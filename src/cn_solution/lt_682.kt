package cn_solution

import java.util.*

fun calPoints(ops: Array<String>): Int {
    val s = Stack<Int>()
    return ops.sumBy { op ->
        when (op) {
            "C" -> -s.pop()
            "D" -> (s.peek() * 2).also { s.push(it) }
            "+" -> (s.peek() + s[s.size - 2]).also { s.push(it) }
            else -> op.toInt().also { s.push(it) }
        }
    }
}