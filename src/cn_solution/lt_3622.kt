package cn_solution

fun checkDivisibility(n: Int): Boolean {
    var sum = 0
    var mul = 1
    var tmp = n
    while (tmp > 0) {
        val rem = tmp % 10
        sum += rem
        mul *= rem
        tmp /= 10
    }
    return n % (sum + mul) == 0
}