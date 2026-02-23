package cn_solution

fun checkStrings(s1: String, s2: String): Boolean {
    val cnt = Array(2) { IntArray(26) }
    for (i in s1.indices) {
        cnt[i and 1][s1[i] - 'a']++
        cnt[i and 1][s2[i] - 'a']--
    }
    return cnt.all { it.all { x -> x == 0 } }
}