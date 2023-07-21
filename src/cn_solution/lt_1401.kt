package cn_solution

fun checkOverlap(radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    fun square(n: Int) = n * n
    val distance = square(radius)
    return (xCenter in x1..x2 && yCenter in y1 - radius..y2 + radius)
            || (yCenter in y1..y2 && xCenter in x1 - radius..x2 + radius)
            || arrayOf(
        arrayOf(x1, y1), arrayOf(x1, y2), arrayOf(x2, y1), arrayOf(x2, y2)
    ).any { (x, y) -> square(x - xCenter) + square(y - yCenter) <= distance }
}