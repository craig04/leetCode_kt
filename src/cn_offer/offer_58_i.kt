package cn_offer

fun reverseWords(s: String): String {
    val words = ArrayList<Pair<Int, Int>>()
    var i = 0
    while (true) {
        while (i != s.length && s[i] == ' ')
            i++
        if (i == s.length)
            break
        var j = i + 1
        while (j != s.length && s[j] != ' ')
            j++
        words.add(Pair(i, j))
        i = j
    }
    return words.asReversed().joinToString(" ") {
        s.substring(it.first, it.second)
    }
}