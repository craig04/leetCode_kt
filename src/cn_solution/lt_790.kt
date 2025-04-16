package cn_solution

fun numTilings(n: Int): Int {
    if (n == 1)
        return 1
    var a = 1
    var b = 1
    var c = 2
    repeat(n - 2) {
        val x = a
        a = b
        b = c
        c = (2L * c + x).mod(1000000007)
    }
    return c
}