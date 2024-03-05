package cn_solution

fun nthMagicalNumber(n: Int, a: Int, b: Int): Int {
    fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
    val modulo = 1000000007
    val lcm = a * b / gcd(a, b)
    val cnt = lcm / a + lcm / b - 1
    val group = n / cnt
    val remain = n - group * cnt
    val base = (group.toLong() * lcm % modulo).toInt()
    var x = 0
    var y = 0
    repeat(remain) {
        if (x + a < y + b)
            x += a
        else
            y += b
    }
    return (base + maxOf(x, y) % modulo) % modulo
}