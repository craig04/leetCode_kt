package cn_solution

fun shortestPalindrome(s: String): String {
    if (s.isEmpty())
        return s
    val sb = StringBuilder("^")
    s.forEach { sb.append(it).append('#') }
    sb[sb.lastIndex] = '$'
    val len = IntArray(sb.length)
    var mid = 0
    var right = 0
    for (i in 2 until sb.length - 2) {
        if (i < right)
            len[i] = minOf(right - i, len[mid * 2 - i])
        while (sb[i + len[i] + 1] == sb[i - len[i] - 1])
            len[i]++
        if (i + len[i] > right) {
            mid = i
            right = i + len[i]
        }
    }
    val pos = sb.indices.last { len[it] == it - 1 }
    return s.substring(pos).reversed() + s
}