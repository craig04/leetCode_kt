package cn_solution

fun maxPower(stations: IntArray, r: Int, k: Int): Long {
    val n = stations.size
    val d = LongArray(n + 1)
    stations.forEachIndexed { i, p ->
        d[maxOf(0, i - r)] += p
        d[minOf(n, i + r + 1)] -= p
    }
    val power = LongArray(n)
    var sum = 0L
    var low = Long.MAX_VALUE
    for (i in 0 until n) {
        sum += d[i]
        power[i] = sum
        low = minOf(low, sum)
    }
    var high = low + k
    loop@ while (low != high) {
        val mid = (low + high + 1) / 2
        var ext = 0L
        sum = 0
        d.fill(0)
        for (i in 0 until n) {
            sum += d[i]
            val gap = mid - power[i] - sum
            if (gap <= 0)
                continue
            ext += gap
            if (ext > k) {
                high = mid - 1
                continue@loop
            }
            sum += gap
            d[minOf(n, i + 2 * r + 1)] -= gap
        }
        low = mid
    }
    return low
}