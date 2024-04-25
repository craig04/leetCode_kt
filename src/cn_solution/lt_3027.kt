package cn_solution

fun numberOfPairs(points: Array<IntArray>): Int {
    points.sortWith(compareBy({ it[0] }, { -it[1] }))
    var result = 0
    for (i in points.indices) {
        val top = points[i][1]
        var bottom = Int.MIN_VALUE
        for (j in i + 1 until points.size) {
            if (points[j][1] in bottom..top) {
                result++
                bottom = points[j][1] + 1
            }
        }
    }
    return result
}