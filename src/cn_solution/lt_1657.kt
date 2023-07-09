package cn_solution

fun closeStrings(word1: String, word2: String): Boolean {
    fun String.stat() = IntArray(26).also {
        for (c in this)
            it[c - 'a']++
    }
    if (word1.length != word2.length)
        return false
    val s1 = word1.stat()
    val s2 = word2.stat()
    if (s1.indices.any { (s1[it] == 0) != (s2[it] == 0) })
        return false
    s1.sort()
    s2.sort()
    return s1.indices.all { s1[it] == s2[it] }
}