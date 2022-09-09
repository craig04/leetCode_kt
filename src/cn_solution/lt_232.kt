package cn_solution

import java.util.*

class MyQueue() {

    val s1 = Stack<Int>()
    val s2 = Stack<Int>()

    fun push(x: Int) {
        s1.push(x)
    }

    fun pop(): Int {
        transfer()
        return s2.pop()
    }

    fun peek(): Int {
        transfer()
        return s2.peek()
    }

    private fun transfer() {
        if (s2.isEmpty())
            while (s1.isNotEmpty())
                s2.push(s1.pop())
    }

    fun empty(): Boolean {
        return s1.isEmpty() && s2.isEmpty()
    }
}