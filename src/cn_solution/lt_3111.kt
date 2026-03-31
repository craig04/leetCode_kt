package cn_solution

fun minRectanglesToCoverPoints(points: Array<IntArray>, w: Int): Int {
    points.sortBy { it[0] }
    var ans = 0
    var r = -1
    for ((x) in points) {
        if (x > r) {
            ans++
            r = x + w
        }
    }
    return ans
}