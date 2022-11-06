package cn_solution

fun bestCoordinate(towers: Array<IntArray>, radius: Int): IntArray {
    var left = Int.MAX_VALUE
    var right = Int.MIN_VALUE
    var bottom = Int.MAX_VALUE
    var top = Int.MIN_VALUE
    for (t in towers) {
        left = minOf(left, t[0])
        right = maxOf(right, t[0])
        bottom = minOf(bottom, t[1])
        top = maxOf(top, t[1])
    }
    var signal = 0
    var p = 0
    var q = 0
    for (i in left..right) {
        for (j in bottom..top) {
            val s = towers.sumBy {
                val x = it[0] - i
                val y = it[1] - j
                val d = Math.sqrt((x * x + y * y).toDouble())
                if (d > radius) 0 else Math.floor(it[2] / (1 + d)).toInt()
            }
            if (s > signal) {
                signal = s
                p = i
                q = j
            }
        }
    }
    return intArrayOf(p, q)
}