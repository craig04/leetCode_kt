package cn_solution

import java.util.*

fun halveArray(nums: IntArray): Int {
    val q = PriorityQueue<Double> { l, r -> r.compareTo(l) }
    var sum = 0.0
    nums.forEach {
        sum += it
        q.add(it.toDouble())
    }
    sum /= 2
    var step = 0
    while (sum > 0) {
        val half = q.poll() * 0.5
        sum -= half
        q.add(half)
        step++
    }
    return step
}