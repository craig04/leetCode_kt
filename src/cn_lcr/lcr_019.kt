package cn_lcr

fun validPalindrome(s: String): Boolean {
    fun isPalindrome(i: Int, j: Int): Boolean {
        var p = i
        var q = j
        while (p < q)
            if (s[p++] != s[q--])
                return false
        return true
    }

    var i = 0
    var j = s.lastIndex
    while (i < j) {
        if (s[i] != s[j])
            break
        i++
        j--
    }
    return i >= j - 1 || isPalindrome(i, j - 1) || isPalindrome(i + 1, j)
}