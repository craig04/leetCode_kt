package cn_solution

fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = heights.size
    val m = heights[0].size
    val row = 0 until n
    val col = 0 until m
    fun flow(r: Int, c: Int): Array<BooleanArray> {
        val q = ArrayDeque<IntArray>()
        val vis = Array(n) { BooleanArray(m) }
        for (i in row) {
            q.add(intArrayOf(i, c))
            vis[i][c] = true
        }
        for (j in col) {
            q.add(intArrayOf(r, j))
            vis[r][j] = true
        }
        while (q.isNotEmpty()) {
            val (x, y) = q.removeFirst()
            for (i in d.indices step 2) {
                val u = x + d[i]
                val v = y + d[i + 1]
                if (u in row && v in col && !vis[u][v] && heights[u][v] >= heights[x][y]) {
                    vis[u][v] = true
                    q.addLast(intArrayOf(u, v))
                }
            }
        }
        return vis
    }

    val pacific = flow(0, 0)
    val atlantic = flow(n - 1, m - 1)
    val ans = ArrayList<List<Int>>()
    for (i in row)
        for (j in col)
            if (pacific[i][j] && atlantic[i][j])
                ans.add(listOf(i, j))
    return ans
}