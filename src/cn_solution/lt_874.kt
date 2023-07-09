package cn_solution

fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
    var result = 0
    var x = 0
    var y = 0
    var direction = 0
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    val obs = obstacles.mapTo(HashSet()) { (x, y) -> x * 60001 + y }
    for (c in commands) {
        if (c == -1)
            direction = (direction + 1) % 4
        else if (c == -2)
            direction = (direction + 3) % 4
        else {
            var p = x
            var q = y
            for (i in 0..c) {
                p += dx[direction]
                q += dy[direction]
                if (p * 60001 + q in obs)
                    break
            }
            x = p - dx[direction]
            y = q - dy[direction]
            result = maxOf(result, x * x + y * y)
        }
    }
    return result
}