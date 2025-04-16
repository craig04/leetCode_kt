package cn_solution

fun maxProfit(n: Int, edges: Array<IntArray>, score: IntArray): Int {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges)
        g[v].add(u)
    val pre = IntArray(n) { -1 }
    fun dfs1(x: Int): Int {
        if (pre[x] == -1)
            pre[x] = g[x].fold(0) { res, y ->
                1.shl(y) or dfs1(y) or res
            }
        return pre[x]
    }
    for (i in 0 until n)
        dfs1(i)
    val res = IntArray(1.shl(n)) { -1 }
    res[0] = 0
    fun dfs2(x: Int): Int {
        if (res[x] == -1) {
            var profit = 0
            var y = x
            while (y != 0) {
                val i = y.takeLowestOneBit()
                y = y xor i
                profit += score[i.countTrailingZeroBits()]
            }
            y = x
            while (y != 0) {
                val i = y.takeLowestOneBit()
                y = y xor i
                if (pre[i.countTrailingZeroBits()] and x == 0)
                    res[x] = maxOf(res[x], profit + dfs2(x xor i))
            }
        }
        return res[x]
    }
    return dfs2(1.shl(n) - 1)
}