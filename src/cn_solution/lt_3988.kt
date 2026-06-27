package cn_solution

fun createGrid(m: Int, n: Int, k: Int): Array<String> {
    val min = minOf(n, m)
    val max = maxOf(n, m)
    if (min == 1) {
        if (k == 1)
            return Array(m) { String(CharArray(n) { '.' }) }
        return arrayOf()
    }
    if (min == 2 && max < k)
        return arrayOf()
    if (n == 3 && m == 3 && k == 4)
        return arrayOf("..#", "...", "#..")
    val ans = Array(m) { CharArray(n) { '#' } }
    var x = 2
    var y = k
    if (y > n) {
        x = k
        y = 2
    }
    for (i in 0 until x)
        for (j in 0 until y)
            ans[i][j] = '.'
    for (i in x until m)
        ans[i][y - 1] = '.'
    for (j in y until n)
        ans[m - 1][j] = '.'
    return Array(m) { String(ans[it]) }
}