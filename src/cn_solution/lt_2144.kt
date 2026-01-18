package cn_solution

private fun minimumCost(cost: IntArray): Int {
    cost.sortDescending()
    return cost.indices.sumOf { if (it % 3 == 2) 0 else cost[it] }
}