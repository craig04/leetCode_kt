package cn_solution

private fun numberOfSpecialChars(word: String): Int {
    var l = 0
    var u = 0
    for (c in word)
        if (c.isLowerCase())
            l = 1 shl (c - 'a') or l
        else
            u = 1 shl (c - 'A') or u
    return l.and(u).countOneBits()
}