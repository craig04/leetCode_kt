package cn_solution

import java.util.*

private fun calculate(s: String): Int {
    fun Char.calculate(a: Int, b: Int) = when (this) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        else -> a / b
    }

    fun Char.priority() = if (this == '+' || this == '-') 0 else 1
    val num = Stack<Int>()
    val ops = Stack<Char>()
    num.push(0)
    ops.push('+')
    var cur = 0
    for (c in s) {
        if (c == ' ')
            continue
        if (c in '0'..'9') {
            cur = c - '0' + cur * 10
            continue
        }
        while (ops.isNotEmpty() && ops.last().priority() >= c.priority())
            cur = ops.pop().calculate(num.pop(), cur)
        num.add(cur)
        ops.add(c)
        cur = 0
    }
    while (ops.isNotEmpty())
        cur = ops.pop().calculate(num.pop(), cur)
    return cur
}