package cn_interview

import java.util.*

class MyQueue() {

    /** Initialize your data structure here. */
    val s1 = Stack<Int>()
    val s2 = Stack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        s1.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        transfer()
        return s2.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        transfer()
        return s2.peek()
    }

    private fun transfer() {
        if (s2.isEmpty()) {
            while (s1.isNotEmpty())
                s2.push(s1.pop())
        }
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return s1.isEmpty() && s2.isEmpty()
    }
}