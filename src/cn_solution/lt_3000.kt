package cn_solution

fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
    var diagonal = 0
    var area = 0
    for ((x, y) in dimensions) {
        val d = x * x + y * y
        val a = x * y
        if (d > diagonal || d == diagonal && a > area) {
            diagonal = d
            area = a
        }
    }
    return area
}