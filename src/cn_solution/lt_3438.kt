package cn_solution

fun findValidPair(s: String): String {
    val cnt = IntArray(10)
    s.forEach { cnt[it - '0']++ }
    val f = BooleanArray(10) { it == cnt[it] }
    for (i in 0 until s.lastIndex)
        if (s[i] != s[i + 1] && f[s[i] - '0'] && f[s[i + 1] - '0'])
            return s.substring(i, i + 2)
    return ""
}