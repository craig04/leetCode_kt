package cn_solution

fun knightDialer(n: Int): Int {
    val next = arrayOf(
        intArrayOf(4, 6),
        intArrayOf(6, 8),
        intArrayOf(7, 9),
        intArrayOf(4, 8),
        intArrayOf(0, 3, 9),
        intArrayOf(),
        intArrayOf(0, 1, 7),
        intArrayOf(2, 6),
        intArrayOf(1, 3),
        intArrayOf(2, 4)
    )
    val pre = IntArray(10) { 1 }
    val cur = IntArray(10)
    val modulo = 1000000007
    repeat(n - 1) {
        for (i in 0..9)
            for (j in next[i])
                cur[j] = (cur[j] + pre[i]) % modulo
        cur.copyInto(pre)
        cur.fill(0)
    }
    return pre.reduce { a, b -> (a + b) % modulo }
}