package cn_solution

fun minSensors(n: Int, m: Int, k: Int): Int {
    val len = 2 * k + 1
    val row = (n + len - 1) / len
    val col = (m + len - 1) / len
    return row * col
}