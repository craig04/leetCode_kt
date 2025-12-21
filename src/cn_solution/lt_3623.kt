package cn_solution

private fun countTrapezoids(points: Array<IntArray>): Int {
    val map = points.asSequence().groupingBy { it[1] }.eachCount()
    var mul = 0L
    var ans = 0L
    for ((_, v) in map) {
        val cnt = v * (v - 1L) / 2
        ans += cnt * mul
        mul += cnt
    }
    return ans.mod(1000000007)
}