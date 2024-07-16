package cn_solution

fun maxOperations(s: String): Int {
    var cnt = 0
    return s.indices.sumOf {
        if (s[it] == '0')
            return@sumOf 0
        cnt++
        if (it != s.lastIndex && s[it + 1] == '0') cnt else 0
    }
}