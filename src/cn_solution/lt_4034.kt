package cn_solution

fun minBishopMoves(source: IntArray, target: IntArray): Int {
    val (x, y) = source
    val (a, b) = target
    return when {
        (x + y + a + b) % 2 == 1 -> -1
        (x + y == a + b) || (x - y == a - b) -> 1
        else -> 2
    }
}