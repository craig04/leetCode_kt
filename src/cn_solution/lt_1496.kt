package cn_solution

fun isPathCrossing(path: String): Boolean {
    val set = hashSetOf(0)
    var x = 0
    var y = 0
    return path.any {
        when (it) {
            'N' -> y++
            'S' -> y--
            'E' -> x++
            'W' -> x--
        }
        !set.add(x * 20001 + y)
    }
}