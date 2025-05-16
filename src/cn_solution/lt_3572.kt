package cn_solution

fun maxSumDistinctTriplet(x: IntArray, y: IntArray): Int {
    val map = HashMap<Int, Int>()
    for (i in x.indices)
        map.merge(x[i], y[i], ::maxOf)
    return if (map.size < 3) -1 else map.values.sortedDescending().take(3).sum()
}