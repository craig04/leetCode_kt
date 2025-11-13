package cn_solution

fun minimumFlips(n: Int): Int {
    return Integer.reverse(n)
        .ushr(n.countLeadingZeroBits())
        .xor(n)
        .countOneBits()
}