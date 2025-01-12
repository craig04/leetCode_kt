package cn_solution

fun zigzagTraversal(grid: Array<IntArray>): List<Int> {
    val ans = ArrayList<Int>()
    var x = 0
    var y = 0
    var d = 1
    var f = true
    do {
        if (f)
            ans.add(grid[x][y])
        f = !f
        if (y + d !in grid[x].indices) {
            x++
            d = -d
        } else {
            y += d
        }
    } while (x < grid.size)
    return ans
}