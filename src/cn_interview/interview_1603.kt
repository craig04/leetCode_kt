package cn_interview

fun intersection(start1: IntArray, end1: IntArray, start2: IntArray, end2: IntArray): DoubleArray {
    fun det(a: Int, b: Int, c: Int, d: Int) = a * d - b * c
    val (x1, y1) = start1
    val (x2, y2) = end1
    val (x3, y3) = start2
    val (x4, y4) = end2
    val u = det(x1 - x2, x4 - x3, y1 - y2, y4 - y3)
    val v = det(x4 - x2, x4 - x3, y4 - y2, y4 - y3)
    val w = det(x1 - x2, x4 - x2, y1 - y2, y4 - y2)
    if (u != 0) {
        val a = v.toDouble() / u
        val b = w.toDouble() / u
        if ((0.0..1.0).let { a in it && b in it }) {
            return doubleArrayOf(a * (x1 - x2) + x2, a * (y1 - y2) + y2)
        }
    } else if (v == 0) {
        val p = arrayOf(start1, end1, start2, end2)
        p.sortBy { it[0].shl(8) + it[1] }
        fun IntArray.isStart() = this === start1 || this === end1
        if (p[0].isStart() xor p[1].isStart())
            return DoubleArray(2) { p[1][it].toDouble() }
    }
    return DoubleArray(0)
}