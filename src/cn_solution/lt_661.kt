package cn_solution

fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
    val n = img.size
    val m = img.firstOrNull()?.size ?: return emptyArray()
    return Array(n) { i ->
        IntArray(m) { j ->
            var sum = 0
            var count = 0
            for (u in maxOf(0, i - 1) until minOf(n, i + 2)) {
                for (v in maxOf(0, j - 1) until minOf(m, j + 2)) {
                    sum += img[u][v]
                    count++
                }
            }
            sum / count
        }
    }
}