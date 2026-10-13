package cn_solution

fun lastVisitedCell(grid: Array<CharArray>): IntArray {
    val row = grid.indices
    val col = grid.first().indices
    var i = 0
    var j = 0
    while (true) {
        var x = i
        var y = j
        when (grid[i][j]) {
            'L' -> y--
            'U' -> x--
            'R' -> y++
            'D' -> x++
        }
        if (x !in row || y !in col || grid[x][y] == 'E')
            break
        grid[i][j] = 'E'
        i = x
        j = y
    }
    return intArrayOf(i, j)
}