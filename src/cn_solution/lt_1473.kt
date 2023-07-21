package cn_solution

private const val INF = Int.MAX_VALUE

fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
    var pre = Array(target + 1) { IntArray(n) { INF } }
    var cur = Array(target + 1) { IntArray(n) { INF } }
    pre[1].fill(0)
    for (i in 0 until m) {
        for (t in 1..minOf(i + 1, target)) {
            for (j in 0 until n) {
                if (houses[i] != 0 && houses[i] != j + 1) {
                    cur[t][j] = INF
                    continue
                }
                var c = INF
                for (pj in 0 until n) {
                    val pt = if (pj == j) t else t - 1
                    c = c.coerceAtMost(pre[pt][pj])
                }
                cur[t][j] = if (c == INF) INF else (c + if (houses[i] == 0) cost[i][j] else 0)
            }
        }
        val mid = pre
        pre = cur
        cur = mid
    }
    return pre[target].minOrNull()!!.let { if (it == INF) -1 else it }
}