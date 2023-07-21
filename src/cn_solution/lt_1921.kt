package cn_solution

fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
    val n = dist.size
    val num = IntArray(n)
    dist.forEachIndexed { i, d ->
        num[minOf(n - 1, (d - 1) / speed[i])]++
    }
    var sum = 0
    for (i in num.indices) {
        sum += num[i]
        if (sum > i + 1)
            return i + 1
    }
    return n
}