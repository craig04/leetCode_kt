package cn_solution

fun findMinArrowShots(points: Array<IntArray>): Int {
    points.sortBy { it[1] }
    var count = 0
    var i = 0
    while (i != points.size) {
        val x = points[i++][1]
        while (i != points.size && points[i][0] <= x)
            i++
        count++
    }
    return count
}