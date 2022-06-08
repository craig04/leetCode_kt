package cn_solution

fun diStringMatch(s: String): IntArray {
    val n = s.length
    var l = 0
    var r = n
    val result = IntArray(n + 1)
    for (i in s.indices) {
        result[i] = if (s[i] == 'I') l++ else r--
    }
    result[n] = r
    return result
}