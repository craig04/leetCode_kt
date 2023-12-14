package cn_solution

fun makeSmallestPalindrome(s: String): String {
    val cs = s.toCharArray()
    var i = -1
    var j = s.length
    while (++i < --j) {
        if (cs[i] != cs[j]) {
            val c = minOf(cs[i], cs[j])
            cs[i] = c
            cs[j] = c
        }
    }
    return String(cs)
}