package cn_lcp

fun supplyWagon(supplies: IntArray): IntArray {
    val n = supplies.size
    repeat(n - n / 2) { t ->
        val i = (0 until n - 1 - t).minBy {
            supplies[it] + supplies[it + 1]
        }
        supplies[i] += supplies[i + 1]
        supplies.copyInto(supplies, i + 1, i + 2, n - t)
    }
    return supplies.copyOf(n / 2)
}