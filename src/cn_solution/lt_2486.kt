package cn_solution

fun appendCharacters(s: String, t: String): Int {
    var j = 0
    for (i in s.indices)
        if (s[i] == t[j] && ++j == t.length)
            break
    return t.length - j
}