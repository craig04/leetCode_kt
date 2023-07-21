package cn_offer

fun cuttingRope(n: Int): Int {
    if (n <= 3) return n - 1
    return when (n % 3) {
        0 -> Math.pow(3.0, n / 3.0).toInt()
        1 -> Math.pow(3.0, n / 3 - 1.0).toInt() * 4
        else -> Math.pow(3.0, (n / 3).toDouble()).toInt() * 2
    }
}