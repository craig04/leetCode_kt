package cn_solution

fun smallestString(s: String): String {
    val sb = StringBuilder()
    val n = s.length
    var i = 0
    while (i != s.length && s[i] == 'a') {
        sb.append('a')
        i++
    }
    if (i == s.length) {
        sb[n - 1] = 'a'
        return sb.toString()
    }
    while (i != s.length && s[i] != 'a')
        sb.append(s[i++] - 1)
    sb.append(s, i, n)
    return sb.toString()
}