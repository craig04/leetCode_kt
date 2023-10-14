package cn_lcr

fun uniquePaths(m: Int, n: Int): Int {
    return (1 until n).fold(1L) { acc, i -> acc * (m - 1 + i) / i }.toInt()
}