package cn_solution

fun findComplement(num: Int): Int {
    return num.inv().and(num.takeHighestOneBit().shl(1) - 1)
}