package cn_solution

import java.util.*

/**
 * 使用两个优先队列分别维护较小的一半数字和较大的一半数字
 */
class MedianFinder_PQ() {

    private val q1 = PriorityQueue<Int> { l, r -> r - l }
    private val q2 = PriorityQueue<Int> { l, r -> l - r }

    fun addNum(num: Int) {
        if (q1.size == q2.size) {
            q2.add(num)
            q1.add(q2.poll())
        } else {
            q1.add(num)
            q2.add(q1.poll())
        }
    }

    fun findMedian(): Double {
        return if (q1.size > q2.size)
            q1.peek().toDouble()
        else
            (q1.peek() + q2.peek()) * 0.5
    }
}

/**
 * 使用有序集合维护所有的数字，另外单独维护中间值
 */
class MedianFinder_OrderedSet() {

    private var idx = 0L
    private val set = TreeSet<Long>()
    private var left = Long.MIN_VALUE
    private var right = Long.MAX_VALUE

    fun addNum(num: Int) {
        val data = num.toLong().shl(32) or idx++
        set.add(data)
        if (set.size and 1 == 1) {
            if (data > left)
                left = set.higher(left) ?: 0
            if (data < right)
                right = set.lower(right) ?: 0
        } else {
            if (data < left)
                left = set.lower(left) ?: 0
            if (data > right)
                right = set.higher(right) ?: 0
        }
    }

    fun findMedian(): Double {
        return (left + right).shr(32) / 2.0
    }
}