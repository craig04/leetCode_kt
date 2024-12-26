package cn_solution

import java.util.*

class MyCalendarThree() {

    private val map = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Int {
        map.merge(start, 1, Int::plus)
        map.merge(end, -1, Int::plus)
        var book = 0
        return map.entries.maxOf {
            book += it.value
            book
        }
    }
}