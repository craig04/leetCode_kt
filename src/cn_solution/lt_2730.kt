package cn_solution

fun longestSemiRepetitiveSubstring(s: String): Int {
    var cnt = 0
    var l = 0
    return (1 until s.length).fold(1) { ans, r ->
        if (s[r - 1] == s[r])
            cnt++
        while (cnt > 1) {
            l++
            if (s[l - 1] == s[l])
                cnt--
        }
        maxOf(ans, r - l + 1)
    }
}