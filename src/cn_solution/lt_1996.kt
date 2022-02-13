package cn_solution

fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
    properties.sortWith(object : Comparator<IntArray> {
        override fun compare(lhs: IntArray, rhs: IntArray): Int {
            val diff = rhs[0] - lhs[0]
            return if (diff == 0) lhs[1] - rhs[1] else diff
        }
    })
    var maxDefense = 0
    return properties.count {
        val count = it[1] < maxDefense
        maxDefense = maxOf(maxDefense, it[1])
        count
    }
}