package solution_cn

fun distributeCandies(candyType: IntArray): Int {
    return minOf(candyType.size / 2, candyType.toHashSet().size)
}