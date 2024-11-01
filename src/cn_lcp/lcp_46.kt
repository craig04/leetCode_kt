package cn_lcp

fun volunteerDeployment(finalCnt: IntArray, totalNum: Long, edges: Array<IntArray>, plans: Array<IntArray>): IntArray {
    val n = finalCnt.size + 1
    val g = Array(n) { ArrayList<Int>() }
    edges.forEach { (x, y) ->
        g[x].add(y)
        g[y].add(x)
    }
    val a = LongArray(n)
    val b = LongArray(n)
    a[0] = 1
    for (i in 1 until n)
        b[i] = finalCnt[i - 1].toLong()
    for (i in plans.indices.reversed()) {
        val (num, idx) = plans[i]
        when (num) {
            1 -> {
                a[idx] *= 2L
                b[idx] *= 2L
            }

            2 -> g[idx].forEach {
                a[it] -= a[idx]
                b[it] -= b[idx]
            }

            3 -> g[idx].forEach {
                a[it] += a[idx]
                b[it] += b[idx]
            }
        }
    }
    val x = (totalNum - b.sum()) / a.sum()
    return IntArray(n) { (a[it] * x + b[it]).toInt() }
}