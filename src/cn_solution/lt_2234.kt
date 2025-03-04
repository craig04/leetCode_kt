package cn_solution

fun maximumBeauty(flowers: IntArray, newFlowers: Long, target: Int, full: Int, partial: Int): Long {
    val n = flowers.size
    var left = newFlowers
    for (i in flowers.indices) {
        flowers[i] = minOf(flowers[i], target)
        left -= target - flowers[i]
    }
    if (left == newFlowers)
        return 1L * n * full
    if (left >= 0)
        return maxOf(1L * n * full, (n - 1L) * full + (target - 1L) * partial)
    flowers.sort()
    var j = 0
    var pre = 0L
    return (1..n).maxOf { i ->
        left += target - flowers[i - 1]
        if (left < 0)
            return@maxOf 0
        while (j < i && 1L * flowers[j] * j <= pre + left)
            pre += flowers[j++]
        val avg = (pre + left) / j
        1L * (n - i) * full + 1L * avg * partial
    }
}