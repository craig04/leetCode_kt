package cn_solution

fun colorGrid(n: Int, m: Int, sources: Array<IntArray>): Array<IntArray> {
    val ans = Array(n) { IntArray(m) }
    val q = ArrayDeque<IntArray>()
    sources.sortByDescending { it[2] }
    for ((r, c, color) in sources) {
        ans[r][c] = color
        q.add(intArrayOf(r, c))
    }
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    while (q.isNotEmpty()) {
        val (r, c) = q.removeFirst()
        for (i in dir.indices step 2) {
            val x = r + dir[i]
            val y = c + dir[i + 1]
            if (x in 0 until n && y in 0 until m && ans[x][y] == 0) {
                ans[x][y] = ans[r][c]
                q.addLast(intArrayOf(x, y))
            }
        }
    }
    return ans
}