package cn_solution

fun numberOfBoomerangs(points: Array<IntArray>): Int {
    fun Int.pow() = this * this
    return points.sumOf {
        val map = HashMap<Int, Int>()
        for (q in points) {
            val dist = (it[0] - q[0]).pow() + (it[1] - q[1]).pow()
            map[dist] = (map[dist] ?: 0) + 1
        }
        map.values.sumOf { cnt -> cnt * (cnt - 1) }
    }
}