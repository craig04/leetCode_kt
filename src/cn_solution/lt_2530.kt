package cn_solution

import java.util.PriorityQueue

fun maxKelements(nums: IntArray, k: Int): Long {
    val q = PriorityQueue<Int> { l, r -> r - l }
    q.addAll(nums.asList())
    var result = 0L
    repeat(k) {
        val top = q.poll()
        result += top
        q.offer((top + 2) / 3)
    }
    return result
}