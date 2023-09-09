package cn_solution

fun numSimilarGroups(strs: Array<String>): Int {
    val vst = BooleanArray(strs.size)
    fun dfs(i: Int): Boolean {
        if (vst[i])
            return false
        vst[i] = true
        val p = strs[i]
        strs.forEachIndexed { j, q ->
            var a = -1
            var b = -1
            for (t in p.indices) {
                when {
                    p[t] == q[t] -> continue
                    a == -1 -> a = t
                    b == -1 -> b = t
                    else -> return@forEachIndexed
                }
            }
            if (a == -1 || (b != -1 && p[a] == q[b] && p[b] == q[a]))
                dfs(j)
        }
        return true
    }
    return strs.indices.count { dfs(it) }
}