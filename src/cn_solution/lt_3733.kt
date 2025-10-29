package cn_solution

fun minimumTime(d: IntArray, r: IntArray): Long {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    fun lcm(a: Int, b: Int): Int = a * b / gcd(a, b)
    fun solve(x: Int, y: Int): Long = x + (x - 1L) / (y - 1L)
    val (d1, d2) = d
    val (r1, r2) = r
    return maxOf(
        solve(d1, r1),
        solve(d2, r2),
        solve(d1 + d2, lcm(r1, r2))
    )
}