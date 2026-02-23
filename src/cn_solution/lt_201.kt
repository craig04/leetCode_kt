package cn_solution

fun rangeBitwiseAnd(left: Int, right: Int): Int {
    val tail = 32 - left.xor(right).countLeadingZeroBits()
    return (1.shl(tail) - 1).inv().and(left)
}