package cn_lcp

fun expectNumber(scores: IntArray): Int {
    return scores.toHashSet().size
}