package cn_solution

import java.util.*

class NumberContainers() {

    private val num = HashMap<Int, PriorityQueue<Int>>()
    private val pos = HashMap<Int, Int>()

    fun change(index: Int, number: Int) {
        num.computeIfAbsent(number) { PriorityQueue() }.add(index)
        pos[index] = number
    }

    fun find(number: Int): Int {
        val q = num[number] ?: return -1
        while (q.isNotEmpty() && pos[q.peek()] != number)
            q.poll()
        return if (q.isEmpty()) -1 else q.peek()
    }
}