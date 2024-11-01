package cn_lcp

fun orchestraLayout(num: Int, xPos: Int, yPos: Int): Int {
    val n = minOf(xPos, yPos, num - 1 - xPos, num - 1 - yPos)
    val idx = 4L * n * (num - n) + when {
        xPos <= yPos -> xPos + yPos - 2 * n + 1L
        else -> num * 4L - n * 6L - xPos - yPos - 3
    }
    return ((idx - 1) % 9 + 1).toInt()
}