package cn_solution

import java.util.*

fun openLock(deadends: Array<String>, target: String): Int {
    val s = deadends.toHashSet()
    val q = LinkedList<Pair<String, Int>>()
    val c = CharArray(4) { '0' }
    fun testAndAdd(step: Int) {
        val str = String(c)
        if (s.add(str)) {
            q.offer(str to step + 1)
        }
    }

    testAndAdd(-1)
    while (q.isNotEmpty()) {
        val first = q.poll()
        val str = first.first
        val step = first.second
        if (str == target) {
            return step
        }
        str.toCharArray(c)
        for (i in 0 until 4) {
            val temp = c[i]
            if (c[i]++ == '9')
                c[i] = '0'
            testAndAdd(step)
            c[i] = temp
            if (c[i]-- == '0')
                c[i] = '9'
            testAndAdd(step)
            c[i] = temp
        }
    }
    return -1
}