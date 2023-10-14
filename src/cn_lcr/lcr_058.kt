package cn_lcr

import java.util.*

class MyCalendar() {

    private val schedule = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        val prev = schedule.lowerEntry(start)
        if (prev != null && prev.value > start)
            return false
        val next = schedule.ceilingEntry(start)
        if (next != null && end > next.key)
            return false
        schedule[start] = end
        return true
    }
}