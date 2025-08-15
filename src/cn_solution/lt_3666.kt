package cn_solution

import java.util.*
import kotlin.math.abs

fun minOperations(s: String, k: Int): Int {
    val n = s.length
    val q = ArrayDeque<IntArray>()
    val init = s.sumOf { it - '0' }
    q.addLast(intArrayOf(init, 0))
    val sets = Array(2) { TreeSet<Int>() }
    for (i in 0..n)
        sets[i and 1].add(i)
    sets[init and 1].remove(init)
    while (q.isNotEmpty()) {
        val (one, ops) = q.removeFirst()
        if (one == n)
            return ops
        val min = abs(one - k)
        val max = n - abs(n - one - k)
        val set = sets[min and 1].tailSet(min)
        val iter = set.iterator()
        while (iter.hasNext()) {
            val next = iter.next()
            if (next > max)
                break
            iter.remove()
            q.addLast(intArrayOf(next, ops + 1))
        }
    }
    return -1
}