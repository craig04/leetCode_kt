package cn_solution

fun minCosts(cost: IntArray): IntArray {
    for (i in 1 until cost.size)
        cost[i] = minOf(cost[i - 1], cost[i])
    return cost
}