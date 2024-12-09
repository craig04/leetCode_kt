package cn_solution

fun maxRectangleArea(points: Array<IntArray>): Int {
    val p = points.mapTo(HashSet()) { (x, y) -> x.shl(7).or(y) }
    val n = points.size
    var ans = -1
    for (i in 0 until n) {
        val (x, y) = points[i]
        for (j in 0 until n) {
            val (u, v) = points[j]
            if (x >= u || y >= v || x.shl(7).or(v) !in p || u.shl(7).or(y) !in p)
                continue
            var cnt = 0
            for ((a, b) in points)
                if (a in x..u && b in y..v && ++cnt > 4)
                    break
            if (cnt == 4)
                ans = maxOf(ans, (u - x) * (v - y))
        }
    }
    return ans
}