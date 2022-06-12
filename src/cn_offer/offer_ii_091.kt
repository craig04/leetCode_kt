package cn_offer

fun minCost(costs: Array<IntArray>): Int {
    var r = 0
    var g = 0
    var b = 0
    for (cost in costs) {
        val x = minOf(g, b) + cost[0]
        val y = minOf(b, r) + cost[1]
        val z = minOf(r, g) + cost[2]
        r = x
        g = y
        b = z
    }
    return minOf(r, g, b)
}