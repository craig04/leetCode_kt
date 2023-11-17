package cn_solution

import kotlin.math.absoluteValue

fun tallestBillboard(rods: IntArray): Int {
    val curr = IntArray(5001) { -1 }
    val next = IntArray(5001) { -1 }
    curr[0] = 0
    next[0] = 0
    for (r in rods) {
        for (i in curr.indices) {
            if (curr[i] == -1)
                continue
            next[i + r] = maxOf(next[i + r], curr[i] + r)
            val dist = (i - r).absoluteValue
            next[dist] = maxOf(next[dist], curr[i] + maxOf(0, r - i))
        }
        next.copyInto(curr)
    }
    return curr[0]
}