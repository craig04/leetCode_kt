package cn_solution

fun validPalindrome(s: String): Boolean {
    fun test(i: Int, j: Int, skip: Boolean = false): Boolean {
        var p = i
        var q = j
        while (p < q) {
            if (s[p] != s[q])
                return skip && (test(p + 1, q) || test(p, q - 1))
            p++
            q--
        }
        return true
    }
    return test(0, s.lastIndex, true)
}