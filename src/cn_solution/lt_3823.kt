package cn_solution

fun reverseByType(s: String): String {
    val x = ArrayList<Char>()
    val y = ArrayList<Char>()
    for (c in s) {
        if (c.isLowerCase())
            x.add(c)
        else
            y.add(c)
    }
    return String(CharArray(s.length) { i ->
        if (s[i].isLowerCase())
            x.removeLast()
        else
            y.removeLast()
    })
}