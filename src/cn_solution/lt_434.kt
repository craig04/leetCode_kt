package cn_solution

fun countSegments(s: String): Int {
    var last = ' '
    var result = 0
    for (c in s) {
        if (c != ' ' && last == ' ')
            result++
        last = c
    }
    return result
}