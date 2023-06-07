package cn_interview

fun printKMoves(K: Int): List<String> {
    var x = 0
    var y = 0
    var direction = 0
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    val color = HashMap<Int, Int>()
    var (l, t, r, b) = intArrayOf(0, 0, 0, 0)
    repeat(K) {
        val pos = (x + 2048).shl(16) or (y + 2048)
        val c = color[pos] ?: 1
        direction = (direction + c + 4) and 3
        color[pos] = -c
        x += dx[direction]
        y += dy[direction]
        l = minOf(l, y)
        t = minOf(t, x)
        r = maxOf(r, y)
        b = maxOf(b, x)
    }
    val map = Array(b - t + 1) { u ->
        CharArray(r - l + 1) { v ->
            val pos = (u + t + 2048).shl(16) or (v + l + 2048)
            if (color[pos] == -1) 'X' else '_'
        }
    }
    map[x - t][y - l] = when (direction) {
        0 -> 'R'
        1 -> 'D'
        2 -> 'L'
        else -> 'U'
    }
    return map.map { String(it) }
}