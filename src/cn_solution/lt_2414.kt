package cn_solution

fun longestContinuousSubstring(s: String): Int {
    var ans = 1
    var i = 0
    while (i != s.length) {
        var j = i + 1
        while (j != s.length && s[j] - s[j - 1] == 1)
            j++
        ans = maxOf(ans, j - i)
        i = j
    }
    return ans
}