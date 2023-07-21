package cn_offer

fun sumNums(n: Int): Int {
    fun helper(n: Int, m: Int): Int {
        m > 0 && return n
        return 0
    }

    fun quick(n: Int, m: Int): Int {
        m > 0 && return quick(n, m shr 1).shl(1) + helper(n, m and 1)
        return 0
    }
    return quick(n, n + 1) shr 1
}