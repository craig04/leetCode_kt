package cn_solution

fun generateParenthesis(n: Int): List<String> {
    val ans = ArrayList<String>()
    val buf = CharArray(2 * n)
    fun dfs(l: Int, r: Int) {
        if (r == n) {
            ans += String(buf)
            return
        }
        if (l != n) {
            buf[l + r] = '('
            dfs(l + 1, r)
        }
        if (l != r) {
            buf[l + r] = ')'
            dfs(l, r + 1)
        }
    }
    dfs(0, 0)
    return ans
}