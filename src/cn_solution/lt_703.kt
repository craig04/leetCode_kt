package cn_solution

import java.util.*

class KthLargest(val k: Int, nums: IntArray) {

    val q = PriorityQueue<Int>()

    init {
        nums.forEach { add(it) }
    }

    fun add(`val`: Int): Int {
        if (q.size < k) {
            q.offer(`val`)
        } else if (q.peek() < `val`) {
            q.poll()
            q.offer(`val`)
        }
        return q.peek()
    }
}