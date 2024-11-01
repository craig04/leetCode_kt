package cn_lcp

fun perfectMenu(materials: IntArray, cookbooks: Array<IntArray>, attribute: Array<IntArray>, limit: Int): Int {
    val n = cookbooks.size
    fun dfs(i: Int, deli: Int, full: Int): Int {
        if (i == n)
            return if (full >= limit) deli else -1
        var ans = dfs(i + 1, deli, full)
        cookbooks[i].forEachIndexed { j, m -> materials[j] -= m }
        if (materials.all { it >= 0 })
            ans = maxOf(ans, dfs(i + 1, deli + attribute[i][0], full + attribute[i][1]))
        cookbooks[i].forEachIndexed { j, m -> materials[j] += m }
        return ans
    }
    return dfs(0, 0, 0)
}