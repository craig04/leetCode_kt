package cn_solution

fun numOfWays(n: Int): Int {
    val modulo = 1000000007
    var a = 6L
    var b = 6L
    repeat(n - 1) {
        val x = 2 * (a + b) % modulo
        val y = (x + b) % modulo
        a = x
        b = y
    }
    return (a + b).mod(modulo)
}