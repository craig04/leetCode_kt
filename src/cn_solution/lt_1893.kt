package cn_solution

fun isCovered(ranges: Array<IntArray>, left: Int, right: Int): Boolean {
    fun hash(l: Int, r: Int) = 1L.shl(r + 1) - 1L.shl(l)
    val target = hash(left, right)
    return ranges.fold(0L) { res, (l, r) -> res or hash(l, r) } and target == target
}