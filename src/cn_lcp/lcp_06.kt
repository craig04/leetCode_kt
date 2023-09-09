package cn_lcp

fun minCount(coins: IntArray): Int {
    return coins.sumOf { (it + 1) shr 1 }
}