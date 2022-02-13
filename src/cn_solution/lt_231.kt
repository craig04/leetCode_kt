package cn_solution

fun isPowerOfTwo(n: Int): Boolean {
    return n > 0 && Integer.lowestOneBit(n) == n
}