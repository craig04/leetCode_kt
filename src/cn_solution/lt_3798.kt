package cn_solution

fun largestEven(s: String): String {
    var pos = s.lastIndex
    while (pos >= 0 && s[pos] == '1')
        pos--
    return s.take(pos + 1)
}