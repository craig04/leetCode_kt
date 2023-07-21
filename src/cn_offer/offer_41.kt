package cn_offer

import java.util.*

class MedianFinder() {

    /** initialize your data structure here. */

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