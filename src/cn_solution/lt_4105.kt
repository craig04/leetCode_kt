package cn_solution

@Suppress("LocalVariableName")
fun repeatedStringMatch(a: String, b: String, x: Int, y: Int): Boolean {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val n = a.length
    val m = b.length
    val N = n * 1L * x
    val M = m * 1L * y
    if (N < M)
        return false
    val offset = minOf(N - M, n - 1L).toInt()
    val length = minOf(1L * n * m / gcd(n, m), M).toInt()
    val s = a.repeat((offset + length + n - 1) / n)
    val t = b.repeat(length / m)
    return t in s
}