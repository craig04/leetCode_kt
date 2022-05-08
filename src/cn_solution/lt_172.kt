package cn_solution

fun trailingZeroes(n: Int): Int {
    var result = 0
    var temp = n
    while (temp != 0) {
        temp /= 5
        result += temp
    }
    return result
}