package cn_solution

fun maxSumOfSquares(num: Int, sum: Int): String {
    if (num * 9 < sum)
        return ""
    var s = sum
    return String(CharArray(num) {
        val d = minOf(9, s)
        s -= d
        '0' + d
    })
}