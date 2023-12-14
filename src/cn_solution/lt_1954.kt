package cn_solution

fun minimumPerimeter(neededApples: Long): Long {
    var l = 0L
    var r = 100000L
    while (l != r) {
        val m = (l + r) / 2
        if (2 * m * (m + 1) * (2 * m + 1) >= neededApples)
            r = m
        else
            l = m + 1
    }
    return r
}