package cn_interview

import java.util.*

class SortedStack() {

    private val number = Stack<Int>()
    private val helper = Stack<Int>()

    fun push(`val`: Int) {
        while (number.isNotEmpty() && number.peek() < `val`) {
            helper.push(number.pop())
        }
        number.add(`val`)
        while (helper.isNotEmpty()) {
            number.push(helper.pop())
        }
    }

    fun pop() {
        if (number.isNotEmpty()) {
            number.pop()
        }
    }

    fun peek(): Int {
        return if (number.isEmpty()) -1 else number.peek()
    }

    fun isEmpty(): Boolean {
        return number.isEmpty()
    }
}