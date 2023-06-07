package cn_interview

fun generateParenthesis(n: Int): List<String> {
    val result = ArrayList<String>()
    val sb = StringBuilder()
    fun dfs(left: Int, right: Int) {
        if (left + right == n shl 1) {
            result.add(sb.toString())
            return
        }
        if (left != n) {
            sb.append('(')
            dfs(left + 1, right)
            sb.setLength(sb.length - 1)
        }
        if (left != right) {
            sb.append(')')
            dfs(left, right + 1)
            sb.setLength(sb.length - 1)
        }
    }
    dfs(0, 0)
    return result
}