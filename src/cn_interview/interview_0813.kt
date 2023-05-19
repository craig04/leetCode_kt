package cn_interview

@Suppress("ObjectLiteralToLambda")
fun pileBox(box: Array<IntArray>): Int {
    box.sortWith(object : Comparator<IntArray> {
        override fun compare(lhs: IntArray, rhs: IntArray): Int {
            val (wl, dl, hl) = lhs
            val (wr, dr, hr) = rhs
            return when {
                wl != wr -> wl - wr
                dl != dr -> dr - dl
                else -> hr - hl
            }
        }
    })
    val height = IntArray(box.size)
    return box.indices.fold(0) { acc, i ->
        val (_, d, h) = box[i]
        var pre = 0
        for (j in 0 until i) {
            if (d > box[j][1] && h > box[j][2]) {
                pre = maxOf(pre, height[j])
            }
        }
        height[i] = pre + h
        maxOf(acc, height[i])
    }
}