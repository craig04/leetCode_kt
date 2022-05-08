package cn_solution

fun countNumbersWithUniqueDigits(n: Int): Int {
    var temp = 9
    var result = 1
    for (i in 0 until n) {
        result += temp
        temp *= 9 - i
    }
    return result
}