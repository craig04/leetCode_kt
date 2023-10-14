package cn_solution

fun countDigits(num: Int): Int {
    var result = 0
    var n = num
    while (n != 0) {
        if (num % (n % 10) == 0)
            result++
        n /= 10
    }
    return result
}