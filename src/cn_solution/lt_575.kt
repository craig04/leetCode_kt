package cn_solution

fun distributeCandies(candyType: IntArray): Int {
    return minOf(candyType.size / 2, candyType.toHashSet().size)
}