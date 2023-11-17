package cn_interview

import java.util.Stack

@Suppress("DEPRECATION")
fun calculate(s: String): Int {
    fun Char.priority() = code.rem(5).rem(3)
    fun Char.calculate(a: Int, b: Int) = when (this) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        '/' -> a / b
        else -> 0
    }

    val nums = Stack<Int>()
    val ops = Stack<Char>()
    var num = 0
    for (c in s) {
        if (c == ' ')
            continue
        if (c.isDigit()) {
            num = c - '0' + num * 10
            continue
        }
        while (ops.isNotEmpty() && ops.last().priority() >= c.priority())
            num = ops.pop().calculate(nums.pop(), num)
        nums.push(num)
        ops.push(c)
        num = 0
    }
    return nums.indices.reversed().fold(num) { acc, i ->
        ops[i].calculate(nums[i], acc)
    }
}