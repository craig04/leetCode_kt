package solution

fun checkStraightLine(coordinates: Array<IntArray>): Boolean {

    val x0 = coordinates[0][0]
    val y0 = coordinates[0][1]
    val x1 = coordinates[1][0]
    val y1 = coordinates[1][1]
    return coordinates.all { (it[1] - y1) * (it[0] - x0) == (it[1] - y0) * (it[0] - x1) }
}