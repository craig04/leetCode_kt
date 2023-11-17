package cn_solution

fun minPathCost(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {
    val m = grid[0].size
    val dp = Array(2) { IntArray(m) }
    grid[0].copyInto(dp[0])
    var cur = 0
    for (i in 1 until grid.size) {
        val next = dp[cur xor 1]
        next.fill(Int.MAX_VALUE)
        for (u in next.indices) {
            val from = grid[i - 1][u]
            for (v in next.indices)
                next[v] = minOf(next[v], dp[cur][u] + moveCost[from][v] + grid[i][v])
        }
        cur = cur xor 1
    }
    return dp[cur].min()
}