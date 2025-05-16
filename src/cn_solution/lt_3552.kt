package cn_solution

fun minMoves(matrix: Array<String>): Int {
    val doors = Array(26) { ArrayList<IntArray>() }
    for (i in matrix.indices)
        for (j in matrix[i].indices)
            if (matrix[i][j] in 'A'..'Z')
                doors[matrix[i][j] - 'A'].add(intArrayOf(i, j))
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = matrix.size
    val m = matrix[0].length
    val dis = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val q = ArrayDeque<IntArray>()
    dis[0][0] = 0
    q.addLast(intArrayOf(0, 0))
    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        if (x == n - 1 && y == m - 1)
            return dis[x][y]
        if (matrix[x][y] in 'A'..'Z') {
            for ((u, v) in doors[matrix[x][y] - 'A'])
                if (dis[u][v] > dis[x][y]) {
                    dis[u][v] = dis[x][y]
                    q.addFirst(intArrayOf(u, v))
                }
            doors[matrix[x][y] - 'A'].clear()
        }
        for (i in d.indices step 2) {
            val u = x + d[i]
            val v = y + d[i + 1]
            if (u in 0 until n && v in 0 until m && matrix[u][v] != '#' && dis[u][v] > dis[x][y] + 1) {
                dis[u][v] = dis[x][y] + 1
                q.addLast(intArrayOf(u, v))
            }
        }
    }
    return -1
}