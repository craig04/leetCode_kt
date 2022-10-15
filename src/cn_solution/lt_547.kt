package cn_solution

fun findCircleNum(isConnected: Array<IntArray>): Int {
    val visit = BooleanArray(isConnected.size)
    fun dfs(i: Int): Boolean {
        if (visit[i])
            return false
        visit[i] = true
        isConnected.indices.forEach {
            if (isConnected[i][it] == 1)
                dfs(it)
        }
        return true
    }
    return isConnected.indices.count { dfs(it) }
}
