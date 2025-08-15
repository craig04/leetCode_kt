package cn_solution

fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray {
    return IntArray(queries.size) {
        val (x, y, r) = queries[it]
        points.count { (a, b) ->
            val h = x - a
            val v = y - b
            h * h + v * v <= r * r
        }
    }
}