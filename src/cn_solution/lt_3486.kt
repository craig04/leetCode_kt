package cn_solution

private fun longestSpecialPath(edges: Array<IntArray>, nums: IntArray): IntArray {
    val n = nums.size
    val g = Array(n) { ArrayList<IntArray>() }
    for ((u, v, w) in edges) {
        g[u].add(intArrayOf(v, w))
        g[v].add(intArrayOf(u, w))
    }
    var maxLen = 0
    var minCnt = 1
    val preSum = ArrayList<Int>()
    val lastDepth = HashMap<Int, Int>()
    fun dfs(u: Int, p: Int, sum: Int, once: Int, twice: Int) {
        val curDepth = preSum.size
        preSum.add(sum)
        val color = nums[u]
        val last = lastDepth.put(color, curDepth) ?: -1
        val once2 = maxOf(once, last + 1)
        val twice2 = minOf(once, maxOf(last + 1, twice))
        val len = preSum[curDepth] - preSum[twice2]
        val cnt = curDepth - twice2 + 1
        if (len > maxLen || len == maxLen && cnt < minCnt) {
            maxLen = len
            minCnt = cnt
        }
        for ((v, w) in g[u])
            if (v != p)
                dfs(v, u, sum + w, once2, twice2)
        lastDepth[color] = last
        preSum.removeLast()
    }
    dfs(0, -1, 0, 0, 0)
    return intArrayOf(maxLen, minCnt)
}