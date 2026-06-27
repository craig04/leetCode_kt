package cn_solution

import kotlin.math.abs

fun countValidPrefixes(s: String): Int {
    var cnt = 0
    return s.count {
        cnt += 2 * (it - '0') - 1
        abs(cnt) <= 1
    }
}