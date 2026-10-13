package cn_solution

fun interchangeableRectangles(rectangles: Array<IntArray>): Long {
    val map = HashMap<Double, Int>()
    return rectangles.sumOf { (w, h) ->
        (map.merge(w * 1.0 / h, 1, Int::plus) ?: 1) - 1L
    }
}