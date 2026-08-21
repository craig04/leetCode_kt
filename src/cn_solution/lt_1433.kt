package cn_solution

import kotlin.math.sign

fun checkIfCanBreak(s1: String, s2: String): Boolean {
    val cnt = IntArray(26)
    for (i in s1.indices) {
        cnt[s1[i] - 'a']++
        cnt[s2[i] - 'a']--
    }
    var s = 0
    var x = 0
    return cnt.indices.all {
        s += cnt[it]
        x = 1 shl (s.sign + 1) or x
        x and 5 != 5
    }
}