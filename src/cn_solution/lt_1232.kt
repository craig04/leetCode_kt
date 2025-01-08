package cn_solution

fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    val (a, b) = coordinates[0]
    val (c, d) = coordinates[1]
    return (2 until coordinates.size).all {
        val (x, y) = coordinates[it]
        (x - a) * (y - d) == (x - c) * (y - b)
    }
}