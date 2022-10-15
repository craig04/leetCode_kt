package cn_solution

fun generateParenthesis(n: Int): List<String> {
    val result = ArrayList<String>()
    val sb = StringBuilder()
    fun dfs(i: Int, j: Int) {
        if (i == n && j == n) {
            result.add(sb.toString())
            return
        }
        if (i != n) {
            sb.append('(')
            dfs(i + 1, j)
            sb.setLength(sb.length - 1)
        }
        if (i != j) {
            sb.append(')')
            dfs(i, j + 1)
            sb.setLength(sb.length - 1)
        }
    }
    dfs(0, 0)
    return result
}
