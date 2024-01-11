package cn_solution

private const val MOD = 1000000007

fun numOfWays(n: Int): Int {
    var a = 6L
    var b = 6L
    repeat(n - 1) {
        val x = (2L * a + 2L * b) % MOD
        val y = (2L * a + 3L * b) % MOD
        a = x
        b = y
    }
    return ((a + b) % MOD).toInt()
}