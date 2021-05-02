package solution_cn

fun leastBricks(wall: List<List<Int>>): Int {
    val map = HashMap<Int, Int>()
    wall.forEach {
        var sum = 0
        for (i in 0 until it.lastIndex) {
            sum += it[i]
            map[sum] = (map[sum] ?: 0) + 1
        }
    }
    return wall.size - map.values.fold(0) { acc, i -> maxOf(acc, i) }
}