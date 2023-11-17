package cn_solution

fun minMaxDifference(num: Int): Int {
    val digit = num.toString().toCharArray()
    val c1 = digit.firstOrNull { it != '0' } ?: '0'
    val c2 = digit.firstOrNull { it != '9' } ?: '9'
    var min = num
    var max = num
    var base = 1
    for (i in digit.indices.reversed()) {
        if (digit[i] == c1)
            min -= base * (c1 - '0')
        if (digit[i] == c2)
            max += base * ('9' - c2)
        base *= 10
    }
    return max - min
}