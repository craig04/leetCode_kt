package cn_solution

fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
    val wine = DoubleArray(query_row + 3)
    wine[1] = poured.toDouble()
    for (i in 1..query_row) {
        var temp = wine[0]
        for (j in 1..1 + i) {
            val next = maxOf(0.0, temp - 1) / 2 + maxOf(0.0, wine[j] - 1) / 2
            temp = wine[j]
            wine[j] = next
        }
        println(wine.asList())
    }
    return minOf(1.0, wine[query_glass + 1])
}
