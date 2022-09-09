package cn_solution

fun letterCasePermutation(s: String): List<String> {
    val sb = StringBuilder()
    val result = ArrayList<String>()
    fun dfs(i: Int) {
        fun step(c: Char) {
            sb.append(c)
            dfs(i + 1)
            sb.setLength(i)
        }
        if (i == s.length) {
            result.add(sb.toString())
        } else if (s[i].isDigit()) {
            step(s[i])
        } else {
            step(s[i].toLowerCase())
            step(s[i].toUpperCase())
        }
    }
    dfs(0)
    return result
}