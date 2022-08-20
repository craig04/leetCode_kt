package cn_solution

import java.util.*

fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
    var i = 0
    val stack = Stack<Int>()
    for (n in pushed) {
        stack.push(n)
        while (stack.isNotEmpty() && stack.peek() == popped[i]) {
            stack.pop()
            i++
        }
    }
    return stack.isEmpty()
}