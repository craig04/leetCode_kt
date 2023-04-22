package cn_solution

fun smallestEvenMultiple(n: Int): Int {
    return n.shl(n and 1)
}