package cn_solution

fun removeDigit(number: String, digit: Char): String {
    var pos = -1
    for (i in number.indices)
        if (number[i] == digit) {
            pos = i
            if (i != number.lastIndex && number[i] < number[i + 1])
                break

        }
    return number.removeRange(pos, pos + 1)
}