package cn_solution

class NeighborSum(grid: Array<IntArray>) {

    private val n = grid.size
    private val pos = IntArray(n * n)
    private val sum = Array(2) { IntArray(n * n) }
    private val dir = arrayOf(
        intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0),
        intArrayOf(-1, -1, -1, 1, 1, -1, 1, 1)
    )

    init {
        for (idx in 0 until n * n) {
            val i = idx / n
            val j = idx % n
            val num = grid[i][j]
            pos[num] = idx
            for (k in 0 until 2) {
                for (t in dir[k].indices.step(2)) {
                    val u = i + dir[k][t]
                    val v = j + dir[k][t + 1]
                    if (u in 0 until n && v in 0 until n)
                        sum[k][idx] += grid[u][v]
                }
            }
        }
    }

    fun adjacentSum(value: Int): Int {
        return sum[0][pos[value]]
    }

    fun diagonalSum(value: Int): Int {
        return sum[1][pos[value]]
    }
}