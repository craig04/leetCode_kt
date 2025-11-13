package cn_solution

fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
    val d = Array(n + 2) { IntArray(n + 2) }
    for ((a, b, x, y) in queries) {
        d[a + 1][b + 1]++
        d[x + 2][b + 1]--
        d[a + 1][y + 2]--
        d[x + 2][y + 2]++
    }
    for (i in 1..n)
        for (j in 1..n)
            d[i][j] += d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1]
    return Array(n) { i -> IntArray(n) { j -> d[i + 1][j + 1] } }
}