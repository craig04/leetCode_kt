package cn_solution

private fun reverseWords(s: String): String {
    val v = BooleanArray(26)
    "aeiou".forEach { v[it - 'a'] = true }
    val c = s.toCharArray()
    val n = c.size
    var i = 0
    var cnt = 0
    while (i != n && c[i] != ' ')
        if (v[c[i++] - 'a'])
            cnt++
    while (i != n) {
        var j = i + 1
        var tmp = 0
        while (j != n && c[j] != ' ')
            if (v[c[j++] - 'a'])
                tmp++
        if (tmp == cnt)
            c.reverse(i + 1, j)
        i = j
    }
    return String(c)
}