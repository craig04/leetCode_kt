package cn_solution

fun wordSquares(words: Array<String>): List<List<String>> {
    val ans = ArrayList<List<String>>()
    val idx = IntArray(4)
    val use = BooleanArray(words.size)
    fun dfs(i: Int) {
        if (i == 4) {
            val t = words[idx[0]]
            val l = words[idx[1]]
            val r = words[idx[2]]
            val b = words[idx[3]]
            if (t[0] == l[0] && t[3] == r[0] && b[0] == l[3] && b[3] == r[3])
                ans.add(listOf(t, l, r, b))
            return
        }
        for (j in words.indices)
            if (!use[j]) {
                use[j] = true
                idx[i] = j
                dfs(i + 1)
                use[j] = false
            }
    }
    words.sort()
    dfs(0)
    return ans
}