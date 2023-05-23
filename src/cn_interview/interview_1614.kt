package cn_interview

fun bestLine(points: Array<IntArray>): IntArray {
    var most = 0
    val result = IntArray(2)
    for (i in points.indices.reversed()) {
        val (x, y) = points[i]
        val map = HashMap<Double, Int>()
        for (j in points.lastIndex downTo i + 1) {
            val (p, q) = points[j]
            var ratio = (q - y).toDouble() / (p - x)
            when (ratio) {
                -0.0 -> ratio = 0.0
                Double.NEGATIVE_INFINITY -> ratio = Double.POSITIVE_INFINITY
            }
            val count = (map[ratio] ?: 0) + 1
            map[ratio] = count
            if (count >= most) {
                most = count
                result[0] = i
                result[1] = j
            }
        }
    }
    return result
}