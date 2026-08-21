package cn_solution

fun lastRemaining(n: Int): Int {
    val mask1 = 0x55555555
    val mask2 = 1.shl(31 - n.countLeadingZeroBits()) - 1
    return n.or(mask1).and(mask2) + 1
}