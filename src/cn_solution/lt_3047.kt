package cn_solution

fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
    var ans = 0
    for (i in bottomLeft.indices) {
        val (l1, b1) = bottomLeft[i]
        val (r1, t1) = topRight[i]
        if (r1 - l1 <= ans || t1 - b1 <= ans)
            continue
        for (j in i + 1 until bottomLeft.size) {
            val (l2, b2) = bottomLeft[j]
            val (r2, t2) = topRight[j]
            val l = maxOf(l1, l2)
            val b = maxOf(b1, b2)
            val r = minOf(r1, r2)
            val t = minOf(t1, t2)
            ans = maxOf(ans, minOf(r - l, t - b))
        }
    }
    return 1L * ans * ans
}