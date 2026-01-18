package cn_solution

fun almostPalindromic(s: String): Int {
    val n = s.length
    fun test(a: Int, b: Int, del: Boolean = false): Int {
        var l = a
        var r = b
        while (l >= 0 && r < n && s[l] == s[r]) {
            l--
            r++
        }
        return if (del)
            maxOf(test(l, r + 1), test(l - 1, r))
        else
            r - l - 1
    }
    return minOf(n, (0 until 2 * n - 1).maxOf { test(it / 2, (it + 1) / 2, true) })
}