package cn_solution

/**
 * O(n*n) time complexity algorithm
 * TODO Manacher algorithm with O(n) time complexity
 */
private fun longestPalindrome(s: String): String {
    var left = 0
    var right = 0
    fun search(l: Int, r: Int) {
        var x = l
        var y = r
        while (x >= 0 && y < s.length && s[x] == s[y]) {
            x--
            y++
        }
        if (right - left < y - x - 2) {
            left = x + 1
            right = y - 1
        }
    }
    for (i in s.indices) {
        search(i - 1, i + 1)
        search(i - 1, i)
    }
    return s.substring(left, right + 1)
}
