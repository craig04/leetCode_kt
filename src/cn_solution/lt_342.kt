package cn_solution

fun isPowerOfFour(n: Int): Boolean {
    return n.and(n - 1) == 0 && n.and(0x55555555) != 0
}