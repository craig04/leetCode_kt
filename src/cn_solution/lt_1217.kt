package cn_solution

fun minCostToMoveChips(position: IntArray): Int {
    return position.count { it and 1 == 1 }.let { minOf(it, position.size - it) }
}