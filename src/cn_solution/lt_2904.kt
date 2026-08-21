package cn_solution

fun shortestBeautifulSubstring(s: String, k: Int): String {
    if (s.sumOf { it - '0' } < k)
        return ""
    var ans = s
    var cnt = 0
    var i = 0
    for (j in s.indices) {
        cnt += s[j] - '0'
        if (cnt < k)
            continue
        while (cnt > k || s[i] == '0')
            cnt -= s[i++] - '0'
        val t = s.substring(i, j + 1)
        if (t.length < ans.length || (t.length == ans.length && t < ans))
            ans = t
    }
    return ans
}