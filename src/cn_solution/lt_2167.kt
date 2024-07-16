package cn_solution

fun minimumTime(s: String): Int {
    val n = s.length
    var min = 0
    var sum = 0
    return minOf(s.indices.minOf {
        min = minOf(min, it - 2 * sum)
        sum += s[it] - '0'
        min + 2 * sum - it
    } + n - 1, n)
}