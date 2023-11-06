package cn_lcr

fun minCostClimbingStairs(cost: IntArray): Int {
    var a = 0
    var b = 0
    for (i in 2..cost.size) {
        val c = minOf(a + cost[i - 2], b + cost[i - 1])
        a = b
        b = c
    }
    return b
}