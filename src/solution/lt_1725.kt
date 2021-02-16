package solution

fun countGoodRectangles(rectangles: Array<IntArray>): Int {
    var cnt = 0
    var len = 0
    rectangles.forEach {
        val l = minOf(it[0], it[1])
        if (l > len) {
            len = l
            cnt = 1
        } else if (l == len) {
            cnt++
        }
    }
    return cnt
}