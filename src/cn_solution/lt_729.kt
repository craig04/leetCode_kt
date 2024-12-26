package cn_solution

import java.util.*

class MyCalendar() {

    val map = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        var s = start
        var e = end
        val prev = map.floorEntry(start)
        if (prev != null && prev.value > start)
            return false
        val next = map.ceilingEntry(start)
        if (next != null && next.key < end)
            return false
        if (prev?.value == start) {
            s = prev.key
            map.remove(prev.key)
        }
        if (next?.key == end) {
            e = next.value
            map.remove(next.key)
        }
        map[s] = e
        return true
    }

}