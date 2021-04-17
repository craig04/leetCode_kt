package solution_cn

fun findTheDifference(s: String, t: String): Char {
    val count = IntArray(26)
    for (c in t) count[c - 'a']++
    for (c in s) count[c - 'a']--
    return 'a' + count.indexOfFirst { it == 1 }
}