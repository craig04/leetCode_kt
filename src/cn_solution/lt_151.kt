package cn_solution

private fun reverseWords(s: String): String {
    val words = ArrayList<String>()
    var i = 0
    for (j in s.indices) {
        if (s[j] == ' ') {
            if (j != i)
                words.add(s.substring(i, j))
            i = j + 1
        }
    }
    if (i != s.length)
        words.add(s.substring(i))
    return words.asReversed().joinToString(" ")
}