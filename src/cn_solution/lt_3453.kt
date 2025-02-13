package cn_solution

fun separateSquares(squares: Array<IntArray>): Double {
    var min = Int.MAX_VALUE
    var max = 0
    var sum = 0.0
    for ((_, y, s) in squares) {
        min = minOf(min, y)
        max = maxOf(max, y + s)
        sum += 1.0 * s * s
    }
    var l = min + 0.0
    var r = max + 0.0
    while (r - l > 1e-5) {
        val m = (l + r) / 2
        val below = squares.sumOf { (_, y, s) ->
            ((m - y).coerceIn(0.0, s + 0.0)) * s
        }
        if (below * 2 < sum)
            l = m
        else
            r = m
    }
    return l
}