package cn_solution

fun minFlips(a: Int, b: Int, c: Int): Int {
    return Integer.bitCount(a or b xor c) +
            Integer.bitCount(a and b and c.inv())
}