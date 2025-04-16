package cn_solution

fun maxProduct(n: Int): Int {
    var a = 0
    var b = 0
    var m = n
    while (m != 0) {
        val d = m % 10
        if (d > a) {
            b = a
            a = d
        } else if (d > b) {
            b = d
        }
        m /= 10
    }
    return a * b
}