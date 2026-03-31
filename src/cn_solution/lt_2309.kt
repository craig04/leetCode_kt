package cn_solution

fun greatestLetter(s: String): String {
    var lower = 0
    var upper = 0
    for (c in s) {
        if (c.isLowerCase())
            lower = 1 shl (c - 'a') or lower
        else if (c.isUpperCase())
            upper = 1 shl (c - 'A') or upper
    }
    val x = lower and upper
    return if (x == 0) "" else "${'A' + (31 - x.countLeadingZeroBits())}"
}