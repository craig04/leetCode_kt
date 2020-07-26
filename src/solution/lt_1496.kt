package solution

fun isPathCrossing(path: String): Boolean {
    var x = 0
    var y = 0
    val visited = hashSetOf(0)
    return path.any {
        when (it) {
            'N' -> y += 1
            'S' -> y -= 1
            'E' -> x += 1
            'W' -> x -= 1
        }
        val pos = x.shl(16) + y
        !visited.add(pos)
    }
}