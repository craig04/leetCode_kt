package cn_solution

import java.util.*
import kotlin.math.pow

fun pickGifts(gifts: IntArray, k: Int): Long {
    val q = PriorityQueue<Int>(Comparator.reverseOrder())
    q.addAll(gifts.asList())
    repeat(k) { q.add(q.poll().toDouble().pow(0.5).toInt()) }
    return q.fold(0L, Long::plus)
}