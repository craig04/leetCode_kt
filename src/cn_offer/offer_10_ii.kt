package cn_offer

fun numWays(n: Int): Int {
    var a = 1
    var b = 1
    repeat(n - 1) {
        val c = (a + b) % 1000000007
        a = b
        b = c
    }
    return b
}