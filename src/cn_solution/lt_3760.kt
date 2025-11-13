package cn_solution

fun maxDistinct(s: String): Int {
    return s.fold(0) { x, c -> 1.shl(c - 'a').or(x) }.countOneBits()
}