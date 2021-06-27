package solution_cn

fun isPowerOfFour(n: Int): Boolean {
    return n.and(-n) == n && n.and(0x55555555) != 0
}