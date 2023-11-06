package cn_solution

import java.util.*

class RangeModule() {

    private val map = TreeMap<Int, Int>()

    fun addRange(left: Int, right: Int) {
        var start = left
        var end = right
        while (true) {
            val e = map.floorEntry(right)
            if (e == null || e.value < left)
                break
            map.remove(e.key)
            start = minOf(start, e.key)
            end = maxOf(end, e.value)
        }
        map[start] = end
    }

    fun queryRange(left: Int, right: Int): Boolean {
        val e = map.floorEntry(left)
        return e != null && e.value >= right
    }

    fun removeRange(left: Int, right: Int) {
        while (true) {
            val e = map.lowerEntry(right)
            if (e == null || e.value <= left)
                break
            map.remove(e.key)
            if (e.value > right)
                map[right] = e.value
            if (e.key <= left) {
                map[e.key] = left
                break
            }
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * var obj = RangeModule()
 * obj.addRange(left,right)
 * var param_2 = obj.queryRange(left,right)
 * obj.removeRange(left,right)
 */