package cn_lcp

fun minimumSwitchingTimes(source: Array<IntArray>, target: Array<IntArray>): Int {
    val cnt = IntArray(10001)
    source.forEach { a -> a.forEach { cnt[it]++ } }
    target.forEach { a -> a.forEach { cnt[it]-- } }
    return cnt.sumOf { maxOf(it, 0) }
}