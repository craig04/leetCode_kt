package cn_solution

fun isPalindrome(s: String): Boolean {
    var i = -1
    var j = s.length
    while (true) {
        while (++i < j && !s[i].isLetterOrDigit());
        while (--j > i && !s[j].isLetterOrDigit());
        if (i >= j)
            break
        if (s[i].toLowerCase() != s[j].toLowerCase())
            return false
    }
    return true
}
