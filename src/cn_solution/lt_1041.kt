package cn_solution

fun isRobotBounded(instructions: String): Boolean {
    val dx = intArrayOf(0, -1, 0, 1)
    val dy = intArrayOf(1, 0, -1, 0)
    var x = 0
    var y = 0
    var dir = 0
    instructions.forEach {
        when (it) {
            'L' -> dir = (dir + 1) and 3
            'R' -> dir = (dir + 3) and 3
            'G' -> {
                x += dx[dir]
                y += dy[dir]
            }
        }
    }
    return (x == 0 && y == 0) || dir != 0
}