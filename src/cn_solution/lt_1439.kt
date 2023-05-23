package cn_solution

import java.util.*

fun kthSmallest_binarySearch(mat: Array<IntArray>, k: Int): Int {
    return mat.fold(arrayListOf(0)) { cur, line ->
        var left = cur.first() + line.first()
        var right = cur.last() + line.last()
        val size = minOf(k, cur.size * line.size)
        while (left != right) {
            val m = left + (right - left + 1).shr(1)
            var j = line.size
            val count = cur.fold(0L) { acc, it ->
                while (j != 0 && it + line[j - 1] >= m)
                    j--
                acc + j
            }
            if (count < size) left = m else right = m - 1
        }
        val next = ArrayList<Int>()
        for (p in cur) {
            for (q in line) {
                if (p + q >= left)
                    break
                next.add(p + q)
            }
        }
        repeat(size - next.size) { next.add(left) }
        next.sort()
        next
    }.last()
}

fun kthSmallest_priorityQueue(mat: Array<IntArray>, k: Int): Int {
    return mat.fold(arrayListOf(0)) { x, y ->
        val q = PriorityQueue<IntArray> { l, r -> l[0] - r[0] }
        x.forEachIndexed { i, a ->
            q.offer(intArrayOf(a + y[0], i, 0))
        }
        val next = ArrayList<Int>()
        var count = k
        while (count-- != 0 && q.isNotEmpty()) {
            val elem = q.poll()
            val (_, i, j) = elem
            next.add(elem[0])
            if (j != y.lastIndex) {
                elem[0] = x[i] + y[j + 1]
                elem[2] = j + 1
                q.offer(elem)
            }
        }
        next
    }.last()
}