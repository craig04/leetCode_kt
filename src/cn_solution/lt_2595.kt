package cn_solution

fun evenOddBit(n: Int): IntArray {
    val mask = intArrayOf(0x5555, 0xAAAA)
    return IntArray(2) { n.and(mask[it]).countOneBits() }
}