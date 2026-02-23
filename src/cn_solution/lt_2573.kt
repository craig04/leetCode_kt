package cn_solution

fun findTheString(lcp: Array<IntArray>): String {
    val n = lcp.size
    val s = CharArray(n) { ' ' }
    var c = 'a'
    for (i in 0 until n) {
        if (s[i] != ' ')
            continue
        s[i] = c++
        if (s[i] > 'z')
            return ""
        for (j in i + 1 until n) {
            when {
                lcp[i][j] == 0 -> continue
                s[j] == ' ' -> s[j] = s[i]
                s[j] != s[i] -> return ""
            }
        }
    }
    for (i in n - 1 downTo 0)
        for (j in n - 1 downTo 0) {
            val len = when {
                s[i] != s[j] -> 0
                i == n - 1 || j == n - 1 -> 1
                else -> 1 + lcp[i + 1][j + 1]
            }
            if (len != lcp[i][j])
                return ""
        }
    return String(s)
}