package cn_solution

private fun minOperations(queries: Array<IntArray>): Long {
    fun calc(x: Int): Long {
        val m = 32 - x.countLeadingZeroBits()
        val k = (m - 1) / 2 * 2
        return k.toLong().shl(k).shr(1) - 1.shl(k) / 3 + (m + 1L) / 2 * (x + 1 - 1.shl(k))
    }
    return queries.sumOf { (calc(it[1]) - calc(it[0] - 1) + 1) / 2 }
}