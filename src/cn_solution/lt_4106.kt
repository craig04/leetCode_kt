package cn_solution

fun findMismatchedSegments(s1: String, s2: String): List<List<String>> {
    val ans = ArrayList<List<String>>()
    var i = 0
    for (j in s1.indices)
        if (s1[j] == s2[j])
            i = j + 1
        else if (j != s1.lastIndex || s1[j + 1] == s2[j + 1])
            ans += listOf(s1.substring(i, j + 1), s2.substring(i, j + 1))
    return ans
}