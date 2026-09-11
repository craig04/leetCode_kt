package cn_solution

fun minQueenMoves(source: IntArray, target: IntArray): Int {
    val (x, y) = source
    val (u, v) = target
    return when {
        x == u && y == v -> 0
        x == u || y == v || x + y == u + v || x - y == u - v -> 1
        else -> 2
    }
}