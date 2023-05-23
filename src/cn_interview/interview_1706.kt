package cn_interview

fun numberOf2sInRange(n: Int): Int {
    var base = 1
    var result = 0
    while (base < n) {
        result += n / (base * 10) * base
        val digit = n / base % 10
        if (digit > 2) {
            result += base
        } else if (digit == 2) {
            result += n % base + 1
        }
        base *= 10
    }
    return result
}