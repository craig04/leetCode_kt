package cn_solution

import kotlin.math.abs

fun resultingString(s: String): String {
    val ans = s.toCharArray()
    var i = -1
    for (j in ans.indices) {
        if (i != -1) {
            val d = abs(ans[i] - ans[j])
            if (d == 1 || d == 25) {
                i--
                continue
            }
        }
        ans[++i] = ans[j]
    }
    return String(ans, 0, i + 1)
}