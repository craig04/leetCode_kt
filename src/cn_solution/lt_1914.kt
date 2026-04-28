package cn_solution

fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    for (i in 0 until minOf(grid.size, grid.first().size) / 2) {
        val b = grid.lastIndex - i
        val r = grid.first().lastIndex - i
        val row = b - i
        val col = r - i
        fun set(pos: Int, new: Int): Int {
            var x: Int
            var y: Int
            when {
                pos < row -> { x = i + pos; y = i }
                pos < row + col -> { x = b; y = i + pos - row }
                pos < 2 * row + col -> { x = b - pos + row + col; y = r }
                else -> { x = i; y = r - pos + 2 * row + col }
            }
            val res = grid[x][y]
            grid[x][y] = new
            return res
        }

        val len = (row + col) * 2
        for (j in 0 until gcd(len, k)) {
            var curr = j
            var temp = set(curr, 0)
            do {
                val next = (curr + k) % len
                temp = set(next, temp)
                curr = next
            } while (curr != j)
        }
    }
    return grid
}