package cn_solution

fun findKthBit(n: Int, k: Int): Char {
    if (n == 1)
        return '0'
    val mid = 1.shl(n - 1)
    return when {
        k < mid -> findKthBit(n - 1, k)
        k > mid -> '0' + ('1' - findKthBit(n - 1, 2 * mid - k))
        else -> '1'
    }
}