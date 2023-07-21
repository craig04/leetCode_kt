package cn_solution

import java.util.*

fun findReplaceString(s: String, indices: IntArray, sources: Array<String>, targets: Array<String>): String {
    val sb = StringBuilder(s)
    val q = indices.indices
        .filter { s.startsWith(sources[it], indices[it]) }
        .mapTo(PriorityQueue { l, r -> indices[r] - indices[l] }) { it }
    while (q.isNotEmpty()) {
        val i = q.poll()
        sb.replace(indices[i], indices[i] + sources[i].length, targets[i])
    }
    return sb.toString()
}