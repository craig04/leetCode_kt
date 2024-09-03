package cn_solution

fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
    val max = maxOf(a, b, c)
    val min = minOf(a, b, c)
    val mid = a + b + c - min - max
    return if (max == min + 2)
        intArrayOf(0, 0)
    else if (max - mid <= 2 || mid - min <= 2)
        intArrayOf(1, max - min - 2)
    else
        intArrayOf(2, max - min - 2)
}