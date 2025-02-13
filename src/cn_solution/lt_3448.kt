package cn_solution

private fun countSubstrings(s: String): Long {
    val pre = Array(10) { LongArray(9) }
    val cur = LongArray(9)
    return s.sumOf { c ->
        val d = c - '0'
        for (i in 1 until 10) {
            cur.fill(0)
            for (j in 0 until i)
                cur[(j * 10 + d) % i] += pre[i][j]
            cur[d % i]++
            cur.copyInto(pre[i])
        }
        pre[d][0]
    }
}