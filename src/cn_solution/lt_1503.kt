package cn_solution

fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
    return maxOf(
        left.maxOfOrNull { it } ?: 0,
        right.maxOfOrNull { n - it } ?: 0
    )
}