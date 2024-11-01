package cn_solution

fun losingPlayer(x: Int, y: Int): String {
    return if (minOf(x, y / 4) and 1 == 1) "Alice" else "Bob"
}