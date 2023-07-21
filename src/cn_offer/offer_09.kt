package cn_offer

import java.util.*

class CQueue() {

    val s1 = Stack<Int>()
    val s2 = Stack<Int>()

    fun appendTail(value: Int) {
        s1.add(value)
    }

    fun deleteHead(): Int {
        if (s2.isNotEmpty())
            return s2.pop()
        while (s1.isNotEmpty())
            s2.push(s1.pop())
        return if (s2.isEmpty()) -1 else s2.pop()
    }
}
