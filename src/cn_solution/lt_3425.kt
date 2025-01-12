package cn_solution

fun longestSpecialPath(edges: Array<IntArray>, nums: IntArray): IntArray {
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
    fun dfs(u: Int, p: Int, sum: Int, old: Int) {
        preSum.add(sum)
        val dep = lastDepth.put(nums[u], preSum.lastIndex) ?: -1
        val new = maxOf(old, dep)
        val len = sum - preSum[new + 1]
        val cnt = preSum.size - new - 1
        if (len > maxLen || len == maxLen && cnt < minCnt) {
            maxLen = len
            minCnt = cnt
        }
        for ((v, w) in g[u])
            if (v != p)
                dfs(v, u, sum + w, new)
        preSum.removeLast()
        lastDepth[nums[u]] = dep
    }
    dfs(0, -1, 0, -1)
    return intArrayOf(maxLen, minCnt)
}