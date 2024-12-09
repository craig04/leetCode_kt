package cn_solution

fun minimumCost(cost: IntArray): Int {
    cost.sortDescending()
    return cost.indices.sumOf { if (it % 3 == 2) 0 else cost[it] }
}