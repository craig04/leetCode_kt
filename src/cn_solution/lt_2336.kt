package cn_solution

import java.util.*

class SmallestInfiniteSet() {

    private val used = TreeMap<Int, Int>().also { it[0] = 0 }

    fun popSmallest(): Int {
        val (key, value) = used.firstEntry()
        val next = used.remove(value + 2)
        used[key] = next ?: (value + 1)
        return value + 1
    }

    fun addBack(num: Int) {
        val (key, value) = used.floorEntry(num)
        if (num in key..value) {
            used.remove(key)
            if (key != num)
                used[key] = num - 1
            if (value != num)
                used[num + 1] = value
        }
    }
}