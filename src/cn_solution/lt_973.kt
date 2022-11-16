package cn_solution

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val dist = IntArray(points.size) { points[it].let { p -> p[0] * p[0] + p[1] * p[1] } }
    val sorted = (points.indices).sortedBy { dist[it] }
    return Array(k) { points[sorted[it]] }
}
