package cn_offer

fun maximum(a: Int, b: Int): Int {
    val k = ((a.toLong() - b) shr 32 and 1).toInt()
    return a * (1 - k) + b * k
}