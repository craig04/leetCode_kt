package cn_solution

fun numberOfWays(n: Int, x: Int, y: Int): Int {
    val modulo = 1000000007
    val m = minOf(n, x)
    val s = Array(n + 1) { LongArray(m + 1) }
    s[0][0] = 1
    for (i in 1..n)
        for (j in 1..minOf(i, m))
            s[i][j] = (s[i - 1][j - 1] + s[i - 1][j] * j) % modulo
    var stage = 1L
    var score = 1L
    return (1..m).fold(0L) { count, t ->
        stage = stage * (x - t + 1) % modulo
        score = score * y % modulo
        (count + stage * score % modulo * s[n][t]) % modulo
    }.toInt()
}