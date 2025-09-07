package cn_solution

import java.util.*

private fun maxTotalValue(nums: IntArray, k: Int): Long {
    val n = nums.size
    val m = 32 - n.countLeadingZeroBits()
    val st = Array(n) { Array(m) { IntArray(2) } }
    nums.forEachIndexed { i, num -> st[i][0].fill(num) }
    for (j in 1 until m)
        for (i in 0 until n - 1.shl(j - 1)) {
            val x = i + 1.shl(j - 1)
            st[i][j][0] = minOf(st[i][j - 1][0], st[x][j - 1][0])
            st[i][j][1] = maxOf(st[i][j - 1][1], st[x][j - 1][1])
        }
    fun query(l: Int, r: Int): Int {
        val pow = 31 - (r - l).countLeadingZeroBits()
        val x = st[l][pow]
        val y = st[r - 1.shl(pow)][pow]
        return maxOf(x[1], y[1]) - minOf(x[0], y[0])
    }

    val q = PriorityQueue<IntArray> { (a), (b) -> b - a }
    for (i in 0 until n) {
        val res = query(i, n)
        if (res != 0)
            q.offer(intArrayOf(res, i, n))
    }
    var ans = 0L
    var ops = k
    while (ops-- != 0 && q.isNotEmpty()) {
        val a = q.poll()
        ans += a[0]
        a[0] = query(a[1], --a[2])
        if (a[0] != 0)
            q.offer(a)
    }
    return ans
}