package cn_offer

import kotlin.math.pow

fun findNthDigit(n: Int): Int {
    var temp = n
    var digit = 1
    var count = 9
    while (true) {
        val segment = digit * count.toLong()
        if (temp <= segment)
            break
        temp -= segment.toInt()
        digit++
        count *= 10
    }
    val start = 10.0.pow(digit - 1).toInt()
    val offset = --temp / digit
    val number = start + offset
    val index = temp % digit
    return number / 10.0.pow(digit - 1 - index).toInt() % 10
}