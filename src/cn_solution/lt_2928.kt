package cn_solution

private fun distributeCandies(n: Int, limit: Int): Int {
    return (0..minOf(limit, n)).sumOf {
        maxOf(0, limit - kotlin.math.abs(n - it - limit) + 1)
    }
}