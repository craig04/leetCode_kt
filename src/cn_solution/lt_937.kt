package cn_solution

import java.util.*

fun reorderLogFiles(logs: Array<String>): Array<String> {
    val map = HashMap<String, Pair<String?, String>>()
    for (log in logs) {
        val idx = log.indexOf(' ')
        val letter = log[idx + 1].isLetter()
        map[log] = Pair(
            if (letter) log.substring(idx + 1) else null,
            if (letter) log.substring(0, idx) else log
        )
    }
    Arrays.sort(logs) { left, right ->
        val lhs = map[left]!!
        val rhs = map[right]!!
        if (lhs.first == null) {
            if (rhs.first == null) 0 else 1
        } else if (rhs.first == null) {
            -1
        } else {
            val res = lhs.first!!.compareTo(rhs.first!!)
            if (res != 0) res else lhs.second.compareTo(rhs.second)
        }
    }
    return logs
}