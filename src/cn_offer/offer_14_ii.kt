package cn_offer

fun cuttingRope_ii(n: Int): Int {
    if (n <= 3)
        return n - 1
    val init = longArrayOf(4, 6, 9)
    return (7..n step 3).fold(init[(n - 1) % 3]) { res, _ -> res * 3 % 1000000007 }.toInt()
}