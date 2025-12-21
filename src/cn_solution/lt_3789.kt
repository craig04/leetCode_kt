package cn_solution

fun minimumCost(cost1: Int, cost2: Int, costBoth: Int, need1: Int, need2: Int): Long {
    return when {
        need1 < need2 -> minimumCost(cost2, cost1, costBoth, need2, need1)
        costBoth >= cost1 + cost2 -> 1L * cost1 * need1 + 1L * cost2 * need2
        else -> 1L * costBoth * need2 + 1L * (need1 - need2) * minOf(cost1, costBoth)
    }
}