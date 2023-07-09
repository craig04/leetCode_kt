package cn_solution

fun alternateDigitSum(n: Int): Int {
    var a = 1
    var temp = n
    var result = 0
    while (temp != 0) {
        result += (temp % 10) * a
        a = -a
        temp /= 10
    }
    return result * -a
}