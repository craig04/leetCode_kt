package cn_interview

fun patternMatching(pattern: String, value: String): Boolean {
    fun dfs(i: Int, j: Int, a: Pair<Int, Int>?, b: Pair<Int, Int>?): Boolean {
        if (i == pattern.length) {
            return j == value.length
        }
        val p = if (pattern[i] == 'a') a else b
        if (p != null) {
            return value.length - j >= p.second
                    && (0 until p.second).all { value[p.first + it] == value[j + it] }
                    && dfs(i + 1, j + p.second, a, b)
        }
        return (j..value.length).any { end ->
            val len = end - j
            val (x, y, other) = if (pattern[i] == 'a')
                arrayOf(Pair(j, len), b, b)
            else
                arrayOf(a, Pair(j, len), a)
            (other?.second != len || (0 until len).any {
                value[other.first + it] != value[j + it]
            }) && dfs(i + 1, j + len, x, y)
        }
    }
    return dfs(0, 0, null, null)
}