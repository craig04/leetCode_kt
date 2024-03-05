package cn_solution

fun putMarbles(weights: IntArray, k: Int): Long {
    val sum = LongArray(weights.size - 1) { weights[it].toLong() + weights[it + 1] }
    sum.sort()
    val maxRange = sum.size - k + 1 until sum.size
    val minRange = 0 until k - 1
    return maxRange.sumOf { sum[it] } - minRange.sumOf { sum[it] }
}