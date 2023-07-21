package cn_solution

fun subtractProductAndSum(n: Int): Int {
    var m = n
    var sum = 0
    var product = 1
    while (m != 0) {
        val r = m % 10
        m /= 10
        sum += r
        product *= r
    }
    return product - sum
}