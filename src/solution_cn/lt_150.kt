package solution_cn

import java.util.*

fun evalRPN(tokens: Array<String>): Int {
    val nums = Stack<Int>()
    for (t in tokens) {
        if (t.length != 1 || t.first().isDigit()) {
            nums.push(t.toInt())
        } else {
            val r = nums.pop()
            val l = nums.pop()
            val n = when (t) {
                "+" -> l + r
                "-" -> l - r
                "*" -> l * r
                else -> l / r
            }
            nums.push(n)
        }
    }
    return nums.first()
}
