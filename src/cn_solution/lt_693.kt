package cn_solution

fun hasAlternatingBits(n: Int): Boolean {
    val m = n shr 1 xor n
    return m and (m + 1) == 0
}