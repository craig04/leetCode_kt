package cn_interview

fun drawLine(length: Int, w: Int, x1: Int, x2: Int, y: Int): IntArray {
    val a = IntArray(length)
    val offset = w / 32 * y
    for (i in x1..x2) {
        val pos = offset + i / 32
        a[pos] = a[pos] or 1.shl(31 - i % 32)
    }
    return a
}