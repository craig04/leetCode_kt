package cn_solution

class neighborSum(private val grid: Array<IntArray>) {

    private val n = grid.size
    private val position = IntArray(n * n)
    private val adjacent = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    private val diagonal = intArrayOf(-1, -1, -1, 1, 1, -1, 1, 1)

    init {
        for (i in 0 until n)
            for (j in 0 until n)
                position[grid[i][j]] = i * n + j
    }

    fun adjacentSum(value: Int): Int {
        return sum(value, adjacent)
    }

    fun diagonalSum(value: Int): Int {
        return sum(value, diagonal)
    }

    private fun sum(value: Int, delta: IntArray): Int {
        val pos = position[value]
        var ans = 0
        for (t in delta.indices step 2) {
            val x = pos / n + delta[t]
            val y = pos % n + delta[t + 1]
            if (x in 0 until n && y in 0 until n)
                ans += grid[x][y]
        }
        return ans
    }
}