package cn_solution

import java.util.*

fun minMutation(start: String, end: String, bank: Array<String>): Int {
    val set = bank.toHashSet()
    val map = hashMapOf(start to 0)
    val q = LinkedList<String>()
    val alpha = charArrayOf('A', 'C', 'G', 'T')
    q.offer(start)
    while (q.isNotEmpty()) {
        val first = q.pollFirst()
        val move = map[first] ?: 0
        if (first == end) {
            return move
        }
        val gene = first.toCharArray()
        for (i in gene.indices) {
            for (c in alpha) {
                val old = gene[i]
                if (old == c)
                    continue
                gene[i] = c
                val next = String(gene)
                if (next in set && map.putIfAbsent(next, move + 1) == null)
                    q.offer(next)
                gene[i] = old
            }
        }
    }
    return -1
}