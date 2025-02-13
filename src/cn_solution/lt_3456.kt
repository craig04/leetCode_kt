package cn_solution

fun hasSpecialSubstring(s: String, k: Int): Boolean {
    val n = s.length
    var i = 0
    while (i != n) {
        var j = i + 1
        while (j != n && s[j] == s[i])
            j++
        if (j - i == k)
            return true
        i = j
    }
    return false
}