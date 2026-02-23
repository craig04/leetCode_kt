package cn_solution

fun maxActivated(points: Array<IntArray>): Int {
    val p = IntArray(points.size) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    fun union(x: Int, y: Int?) {
        if (y != null)
            p[find(x)] = find(y)
    }

    val pre = HashMap<Int, Int>()
    for (i in points.indices) {
        val (x, y) = points[i]
        union(i, pre.putIfAbsent(x, i))
        union(i, pre.putIfAbsent(y + 1000000001, i))
    }
    val cnt = points.indices.groupingBy(::find).eachCount()
    var x = 0
    var y = 0
    for (c in cnt.values)
        if (c > x) {
            y = x
            x = c
        } else if (c > y)
            y = c
    return x + y + 1
}