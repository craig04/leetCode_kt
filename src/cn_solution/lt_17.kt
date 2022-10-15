package cn_solution

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty())
        return emptyList()

    val letters = arrayOf("abc", "edf", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    val result = ArrayList<String>()
    val sb = StringBuilder()
    fun dfs(i: Int) {
        if (i == digits.length) {
            result.add(sb.toString())
            return
        }
        for (c in letters[digits[i] - '2']) {
            sb.append(c)
            dfs(i + 1)
            sb.setLength(sb.length - 1)
        }
    }
    dfs(0)
    return result
}
