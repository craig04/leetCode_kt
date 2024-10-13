package cn_solution

import java.util.*

private fun calculate(s: String): Int {
    var result = 0
    var num = 0
    var sign = 1
    val stack = Stack<Int>().apply { add(1) }
    var i = 0
    while (i != s.length) {
        when (s[i++]) {
            ' ' -> continue
            '+' -> sign = stack.peek()
            '-' -> sign = -stack.peek()
            '(' -> stack.push(sign)
            ')' -> stack.pop()
            else -> {
                while (i != s.length && s[i].isDigit())
                    num = s[i++] - '0' + num * 10
                result += sign * num
                num = 0
            }
        }
    }
    return result
}