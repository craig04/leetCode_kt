package cn_solution

fun smallestNumber(n: Int): Int {
    return n.takeHighestOneBit().shl(1) - 1
}