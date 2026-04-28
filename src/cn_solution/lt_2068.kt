package cn_solution

import kotlin.math.abs

fun checkAlmostEquivalent(word1: String, word2: String): Boolean {
    val cnt = IntArray(26)
    for (i in word1.indices) {
        cnt[word1[i] - 'a']++
        cnt[word2[i] - 'a']--
    }
    return cnt.all { abs(it) <= 3 }
}