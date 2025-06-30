package cn_solution

fun removePalindromeSub(s: String): Int {
    var i = 0
    var j = s.lastIndex
    while (i < j)
        if (s[i++] != s[j--])
            return 2
    return 1
}