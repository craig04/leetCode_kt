package cn_solution

fun clearDigits(s: String): String {
    val a = CharArray(s.length)
    var pos = 0
    for (c in s) {
        if (c.isLetter())
            a[pos++] = c
        else
            pos--
    }
    return String(a, 0, pos)
}