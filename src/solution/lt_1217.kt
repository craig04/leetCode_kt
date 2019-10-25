package solution

fun minCostToMoveChips(chips: IntArray): Int {
    return chips.count { it and 1 != 0 }.let { minOf(it, chips.size - it) }
}