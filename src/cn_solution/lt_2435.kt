package cn_solution

fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
    val m = grid[0].size
    var sum = 0
    var curr = Array(m) { IntArray(k) }
    grid[0].forEachIndexed { j, num ->
        sum = (sum + num) % k
        curr[j][sum] = 1
    }
    for (i in 1 until grid.size) {
        val line = grid[i]
        val next = Array(m) { IntArray(k) }
        for (j in 0 until m) {
            for (t in 0 until k) {
                val s = (t + line[j]) % k
                next[j][s] = curr[j][t]
                if (j != 0)
                    next[j][s] = (next[j][s] + next[j - 1][t]) % 1000000007
            }
        }
        curr = next
    }
    return curr[m - 1][0]
}