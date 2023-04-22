package cn_solution

import java.util.*

fun longestValidParentheses(s: String): Int {
    var result = 0
    val cnt = IntArray(2)
    for (c in s) {
        cnt[c - '(']++
        if (cnt[0] == cnt[1])
            result = maxOf(result, cnt[0])
        else if (cnt[0] < cnt[1])
            Arrays.setAll(cnt) { 0 }
    }
    Arrays.setAll(cnt) { 0 }
    for (i in s.indices.reversed()) {
        cnt[s[i] - '(']++
        if (cnt[0] == cnt[1])
            result = maxOf(result, cnt[0])
        else if (cnt[0] > cnt[1])
            Arrays.setAll(cnt) { 0 }
    }
    return result * 2
}