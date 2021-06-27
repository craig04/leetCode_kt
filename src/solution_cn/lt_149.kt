package solution_cn

fun maxPoints(points: Array<IntArray>): Int {
    var result = 0
    for (i in points.indices) {
        var temp = 0
        val map = HashMap<Int, Int>()
        for (j in i + 1 until points.size) {
            val gradient = points[j].gradient(points[i])
            val count = (map[gradient] ?: 0) + 1
            temp = maxOf(temp, count)
            map[gradient] = count
        }
        result = maxOf(result, temp)
    }
    return result + 1
}

fun IntArray.gradient(other: IntArray): Int {
    var dx = other[0] - this[0]
    var dy = other[1] - this[1]
    if (dx == 0) return Int.MIN_VALUE
    if (dy == 0) return Int.MAX_VALUE
    val gcd = dx.gcd(dy)
    dx /= gcd
    dy /= gcd
    return dx.abs().shl(16).or(dy.abs()).or(dx.xor(dy).and(Int.MIN_VALUE))
}

private fun Int.abs() = kotlin.math.abs(this)

private tailrec fun Int.gcd(b: Int): Int {
    return if (b == 0) this else b.gcd(this % b)
}