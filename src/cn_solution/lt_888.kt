package cn_solution

fun fairCandySwap(aliceSizes: IntArray, bobSizes: IntArray): IntArray {
    val a = aliceSizes.sum()
    val b = bobSizes.sum()
    val diff = (b - a) / 2
    val set = aliceSizes.toSet()
    return bobSizes.first { it - diff in set }.let { intArrayOf(it - diff, it) }
}