package cn_solution

fun countCoveredBuildings(n: Int, buildings: Array<IntArray>): Int {
    val l = IntArray(n + 1) { Int.MAX_VALUE }
    val b = IntArray(n + 1) { Int.MAX_VALUE }
    val r = IntArray(n + 1) { Int.MIN_VALUE }
    val t = IntArray(n + 1) { Int.MIN_VALUE }
    for ((x, y) in buildings) {
        l[y] = minOf(l[y], x)
        b[x] = minOf(b[x], y)
        r[y] = maxOf(r[y], x)
        t[x] = maxOf(t[x], y)
    }
    return buildings.count { (x, y) -> x > l[y] && x < r[y] && y > b[x] && y < t[x] }
}