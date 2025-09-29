package cn_solution

fun findLexSmallestString(s: String, a: Int, b: Int): String {
    fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
    val n = s.length
    val c = CharArray(n)
    val delta = gcd(a, 10)
    val shiftGap = gcd(b, n)
    fun modify(start: Int) {
        val dec = (c[start] - '0') / delta * delta
        for (i in start until n step 2)
            c[i] = '0' + (c[i] - '0' + 10 - dec) % 10
    }

    return (0 until n step shiftGap).minOf { i ->
        s.toCharArray(c, 0, i, n)
        s.toCharArray(c, n - i, 0, i)
        modify(1)
        if (b and 1 == 1)
            modify(0)
        String(c)
    }
}