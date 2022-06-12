package cn_solution

fun consecutiveNumbersSum(n: Int): Int {
    var result = 0
    var i = 1
    var sum = n
    while (sum > 0) {
        if (sum % i == 0)
            result++
        sum -= i++
    }
    return result
}