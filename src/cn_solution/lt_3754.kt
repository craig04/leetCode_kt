package cn_solution

fun sumAndMultiply(n: Int): Long {
    var sum = 0L
    var pow = 1
    var x = 0
    var m = n
    while (m > 0) {
        val r = m % 10
        sum += r
        if (r != 0) {
            x += r * pow
            pow *= 10
        }
        m /= 10
    }
    return x * sum
}