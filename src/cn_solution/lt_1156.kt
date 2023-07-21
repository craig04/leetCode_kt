package cn_solution

import kotlin.math.sign

fun maxRepOpt1(text: String): Int {
    val count = IntArray(26)
    text.forEach { count[it - 'a']++ }
    var (c1, l1, c2, l2) = intArrayOf(-1, 0, -1, 0)
    var i = 0
    var result = 0
    while (i != text.length) {
        val c3 = text[i] - 'a'
        var j = i + 1
        while (j != text.length && text[j] == text[i])
            j++
        val l3 = j - i
        result = if (c3 != c1 || l2 != 1) {
            maxOf(result, l3 + (count[c3] - l3).sign)
        } else {
            maxOf(result, l3 + l1 + (count[c3] - l3 - l1).sign)
        }
        i = j
        c1 = c2
        l1 = l2
        c2 = c3
        l2 = l3
    }
    return result
}