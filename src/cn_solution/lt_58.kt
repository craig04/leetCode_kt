package cn_solution

fun lengthOfLastWord(s: String): Int {
    var e = s.lastIndex
    while (s[e] == ' ') e--
    var b = e
    while (b >= 0 && s[b] != ' ') b--
    return b - e
}