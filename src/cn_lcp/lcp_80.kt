package cn_lcp

fun evolutionaryRecord(parents: IntArray): String {
    val t = Array(parents.size) { ArrayList<Int>() }
    for (i in 1 until parents.size)
        t[parents[i]].add(i)
    fun dfs(idx: Int): String {
        val sub = Array(t[idx].size) { dfs(t[idx][it]) }
        sub.sort()
        return sub.joinToString("", "0", "1")
    }

    val ans = dfs(0)
    return ans.substring(1, ans.lastIndexOf('0') + 1)
}