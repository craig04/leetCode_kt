package cn_solution

fun reverseWords(s: String): String {
    val result = StringBuilder()
    var i = -1
    while (i != s.length) {
        var j = i + 1
        while (j != s.length && s[j] != ' ')
            j++
        for (t in j - 1 downTo i + 1)
            result.append(s[t])
        if (j != s.length)
            result.append(' ')
        i = j
    }
    return result.toString()
}