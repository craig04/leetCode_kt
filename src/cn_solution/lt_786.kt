package cn_solution

import java.util.*

fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
    val q = PriorityQueue<IntArray> { (a, b), (c, d) -> a * d - b * c }
    for (i in 1 until arr.size)
        q.add(intArrayOf(1, arr[i], 0, i))
    repeat(k - 1) {
        val (_, _, t, i) = q.poll()
        if (t != i - 1)
            q.offer(intArrayOf(arr[t + 1], arr[i], t + 1, i))
    }
    return q.poll().sliceArray(0 until 2)
}