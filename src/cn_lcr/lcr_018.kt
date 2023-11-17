package cn_lcr

fun isPalindrome(s: String): Boolean {
    var i = 0
    var j = s.lastIndex
    while (i < j) {
        while (i < j && !s[i].isLetterOrDigit())
            i++
        while (j > i && !s[j].isLetterOrDigit())
            j--
        if (s[i++].lowercase() != s[j--].lowercase())
            return false
    }
    return true
}