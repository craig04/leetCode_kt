package cn_solution

import kotlin.math.abs

fun alphabetBoardPath(target: String): String {
    val result = StringBuilder()
    var lastX = 0
    var lastY = 0
    for (c in target) {
        val cur = c - 'a'
        val curX = cur % 5
        val curY = cur / 5
        val dx = curX - lastX
        val dy = curY - lastY
        fun Char.append(delta: Int) = repeat(abs(delta)) { result.append(this) }
        if (lastY == 5) {
            (if (dy > 0) 'D' else 'U').append(dy)
        }
        (if (dx > 0) 'R' else 'L').append(dx)
        if (lastY != 5) {
            (if (dy > 0) 'D' else 'U').append(dy)
        }
        result.append('!')
        lastX = curX
        lastY = curY
    }
    return result.toString()
}