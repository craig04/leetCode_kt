package cn_solution

fun twoCitySchedCost(costs: Array<IntArray>): Int {
    costs.sortBy { it[0] - it[1] }
    val n = costs.size / 2
    return (0 until n).sumOf { costs[it][0] } + (n until 2 * n).sumOf { costs[it][1] }
}