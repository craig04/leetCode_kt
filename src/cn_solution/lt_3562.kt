package cn_solution

fun maxProfit(n: Int, present: IntArray, future: IntArray, hierarchy: Array<IntArray>, budget: Int): Int {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in hierarchy)
        g[u - 1].add(v - 1)
    fun dfs(u: Int): Array<IntArray> {
        val res = Array(2) { IntArray(budget + 1) { Int.MIN_VALUE / 2 } }
        res[0][0] = 0
        res[1][0] = 0
        val buy = Array(2) { IntArray(budget + 1) { Int.MIN_VALUE / 2 } }
        val cost = present[u]
        val earn = future[u]
        if (cost <= budget)
            buy[0][cost] = earn - cost
        if (cost / 2 <= budget)
            buy[1][cost / 2] = earn - cost / 2
        for (v in g[u]) {
            val (x, y) = dfs(v)
            for (i in budget downTo 0) {
                for (j in 0..i) {
                    res[0][i] = maxOf(res[0][i], res[0][i - j] + x[j])
                    res[1][i] = maxOf(res[1][i], res[1][i - j] + x[j])
                    buy[0][i] = maxOf(buy[0][i], buy[0][i - j] + y[j])
                    buy[1][i] = maxOf(buy[1][i], buy[1][i - j] + y[j])
                }
            }
        }
        for (i in 0..budget) {
            res[0][i] = maxOf(res[0][i], buy[0][i])
            res[1][i] = maxOf(res[1][i], buy[1][i])
        }
        return res
    }
    return dfs(0)[0].max()
}