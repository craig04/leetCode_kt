package cn_solution

fun findMinimumOperations(s1: String, s2: String, s3: String): Int {
    val len1 = s1.length
    val len2 = s2.length
    val len3 = s3.length
    val len = minOf(len1, len2, len3)
    val pref = (0 until len).firstOrNull {
        s1[it] != s2[it] && s2[it] != s3[it]
    } ?: len
    return if (pref == 0) -1 else len1 + len2 + len3 - 3 * pref
}