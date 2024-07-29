package cn_solution

fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
    return commands.fold(0) { pos, s ->
        when (s[0]) {
            'L' -> pos - 1
            'R' -> pos + 1
            'U' -> pos - n
            else -> pos + n
        }
    }
}