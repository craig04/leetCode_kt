package cn_solution

fun checkGoodInteger(n: Int): Boolean {
    var x = 0
    var m = n
    while (m != 0 && x < 50) {
        val d = m % 10
        x += d * d - d
        m /= 10
    }
    return x >= 50
}