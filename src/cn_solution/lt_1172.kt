package cn_solution

import java.util.*

class DinnerPlates(val capacity: Int) {

    val ss = ArrayList<ArrayList<Int>>()
    val pos = PriorityQueue<Int>()

    fun push(`val`: Int) {
        while (pos.isNotEmpty()) {
            val idx = pos.poll()
            val s = ss.getOrNull(idx) ?: continue
            if (s.size != capacity) {
                s.add(`val`)
                if (s.size != capacity)
                    pos.add(idx)
                return
            }
        }
        ss.add(arrayListOf(`val`))
        if (capacity != 1)
            pos.add(ss.lastIndex)
    }

    fun pop(): Int {
        return popAtStack(ss.lastIndex)
    }

    fun popAtStack(index: Int): Int {
        val s = ss.getOrNull(index) ?: return -1
        val res = s.removeLastOrNull() ?: return -1
        if (!s.isEmpty() || index != ss.lastIndex)
            pos.add(index)
        else while (ss.lastOrNull()?.isEmpty() == true)
            ss.removeLast()
        return res
    }
}