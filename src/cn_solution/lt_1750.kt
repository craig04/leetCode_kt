package cn_solution

fun minimumLength(s: String): Int {
    var l = 0
    var r = s.lastIndex
    while (l < r && s[l] == s[r]) {
        while (l <= r && s[l] == s[r]) l++
        while (l < r && s[r] == s[l - 1]) r--
    }
    return r - l + 1
}
