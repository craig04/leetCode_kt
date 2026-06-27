package cn_solution

fun weightedSum(parent: IntArray, nums: IntArray): Long {
    val n = parent.size
    val g = Array(n) { ArrayList<Int>() }
    for (i in 1 until n)
        g[parent[i]].add(i)
    val h = IntArray(n)
    fun dfs(x: Int, cur: Int): Int {
        h[x] = cur
        return 1 + (g[x].maxOfOrNull { dfs(it, cur + 1) } ?: 0)
    }

    val height = dfs(0, 1)
    return nums.indices.sumOf { i -> nums[i] * (height - h[i] + 1L) }
}