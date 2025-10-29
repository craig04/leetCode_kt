package cn_solution

fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val grid = Array(m) { ByteArray(n) }
    for ((x, y) in guards)
        grid[x][y] = 2
    for ((x, y) in walls)
        grid[x][y] = 3
    for ((x, y) in guards) {
        for (i in d.indices.step(2)) {
            var u = x + d[i]
            var v = y + d[i + 1]
            while (u in 0 until m && v in 0 until n && grid[u][v] <= 1) {
                grid[u][v] = 1
                u += d[i]
                v += d[i + 1]
            }
        }
    }
    return grid.sumOf { line -> line.count { it == 0.toByte() } }
}
