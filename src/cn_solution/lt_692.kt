package cn_solution

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

fun topKFrequent(words: Array<String>, k: Int): List<String> {

    class Helper(var count: Int = 0)

    val freq = HashMap<String, Helper>()
    words.forEach { freq.getOrPut(it) { Helper() }.count++ }

    val q = PriorityQueue(Comparator<String> { lhs, rhs ->
        val diff = freq[lhs]!!.count - freq[rhs]!!.count
        if (diff == 0) rhs.compareTo(lhs) else diff
    })
    freq.keys.forEach {
        q.add(it)
        if (q.size > k) q.poll()
    }
    return LinkedList<String>().apply { repeat(k) { addFirst(q.poll()) } }
}