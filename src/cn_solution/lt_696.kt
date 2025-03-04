package cn_solution

fun countBinarySubstrings(s: String): Int {
    var pre = 0
    var pos = 0
    var ans = 0
    while (pos != s.length) {
        val cur = pos
        while (pos != s.length && s[pos] == s[cur])
            pos++
        val len = pos - cur
        ans += minOf(len, pre)
        pre = len
    }
    return ans
}