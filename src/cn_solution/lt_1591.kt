package cn_solution

private const val MAX = 61

fun isPrintable(targetGrid: Array<IntArray>): Boolean {
    val n = targetGrid.size
    val m = targetGrid[0].size
    val l = IntArray(MAX) { MAX }
    val u = IntArray(MAX) { MAX }
    val r = IntArray(MAX)
    val d = IntArray(MAX)
    val colors = HashSet<Int>()
    for (i in 0 until n)
        for (j in 0 until m) {
            val color = targetGrid[i][j]
            colors.add(color)
            l[color] = minOf(l[color], j)
            u[color] = minOf(u[color], i)
            r[color] = maxOf(r[color], j)
            d[color] = maxOf(d[color], i)
        }
    val g = Array(MAX) { BooleanArray(MAX) }
    val degree = IntArray(MAX)
    for (color in colors) {
        for (i in u[color]..d[color]) {
            for (j in l[color]..r[color]) {
                val other = targetGrid[i][j]
                if (other != color && !g[other][color]) {
                    g[other][color] = true
                    degree[color]++
                }
            }
        }
    }
    val q = colors.filterTo(ArrayDeque()) { degree[it] == 0 }
    var print = 0
    while (q.isNotEmpty()) {
        print++
        val color = q.removeFirst()
        for (other in g[color].indices) {
            if (g[color][other] && --degree[other] == 0)
                q.add(other)
        }
    }
    return print == colors.size
}