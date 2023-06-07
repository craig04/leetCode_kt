package cn_interview

fun printBin(num: Double): String {
    var n = num
    val result = StringBuilder("0.")
    while (n != 0.0 && result.length < 32) {
        n *= 2
        if (n >= 1) {
            result.append(1)
            n -= 1
        } else {
            result.append(0)
        }
    }
    return if (n == 0.0) result.toString() else "ERROR"
}