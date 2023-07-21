package cn_offer

fun fib(n: Int): Int {
    if (n == 0)
        return 0
    var a = 0
    var b = 1
    repeat(n) {
        val c = (a + b) % 1000000007
        a = b
        b = c
    }
    return a
}