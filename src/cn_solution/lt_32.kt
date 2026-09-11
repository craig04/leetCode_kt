package cn_solution

fun longestValidParentheses(s: String): Int {
    fun solve(range: IntProgression, left: Char): Int {
        var ans = 0
        var l = 0
        var r = 0
        for (i in range) {
            if (s[i] == left)
                l++
            else if (++r == l)
                ans = maxOf(ans, r)
            else if (r > l) {
                l = 0; r = 0
            }
        }
        return ans
    }
    return maxOf(solve(s.indices, '('), solve(s.indices.reversed(), ')'))
}