package cn_solution

fun lastSubstring(s: String): String {
    var i = 0
    var j = 1
    while (j < s.length) {
        var k = 0
        while (j + k < s.length && s[i + k] == s[j + k])
            k++
        if (j + k == s.length || s[i + k] > s[j + k]) {
            j += k + 1
        } else {
            val t = i
            i = j
            j = maxOf(t + k, j) + 1
        }
    }
    return s.substring(i)
}