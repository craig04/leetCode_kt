package cn_solution

fun flipLights(n: Int, presses: Int): Int {
    return when (presses) {
        0 -> 1
        1 -> minOf(4, n + 1)
        2 -> minOf(7, 1 shl minOf(3, n))
        else -> 1 shl minOf(3, n)
    }
}
