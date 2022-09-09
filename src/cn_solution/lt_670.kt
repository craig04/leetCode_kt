package cn_solution

fun maximumSwap(num: Int): Int {
    var base = 1
    var digit = 0
    var maxBase = 1
    var maxDigit = 0
    var temp = num
    var result = num
    while (temp != 0) {
        digit = temp % 10
        if (digit > maxDigit) {
            maxBase = base
            maxDigit = digit
        } else if (digit < maxDigit) {
            result = num + (maxDigit - digit) * (base - maxBase)
        }
        temp /= 10
        base *= 10
    }
    return result
}
