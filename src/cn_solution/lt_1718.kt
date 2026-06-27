package cn_solution

fun constructDistancedSequence(n: Int): IntArray {
    val ans = IntArray(2 * n - 1)
    val use = BooleanArray(n + 1)
    fun dfs(i: Int): Boolean {
        if (i == 2 * n - 1)
            return true
        if (ans[i] != 0)
            return dfs(i + 1)
        for (x in n downTo 1) {
            if (use[x])
                continue
            val j = if (x == 1) i else i + x
            if (j < ans.size && ans[j] == 0) {
                use[x] = true
                ans[i] = x
                ans[j] = x
                if (dfs(i + 1))
                    return true
                ans[j] = 0
                ans[i] = 0
                use[x] = false
            }
        }
        return false
    }
    dfs(0)
    return ans
}