package cn_solution

fun canEat(candiesCount: IntArray, queries: Array<IntArray>): BooleanArray {
    val acc = LongArray(candiesCount.size + 1)
    for (i in candiesCount.indices) {
        acc[i + 1] = acc[i] + candiesCount[i]
    }
    return BooleanArray(queries.size) {
        val q = queries[it]
        val least = q[1] + 1
        val most = q[1].toLong() * q[2] + q[2]
        acc[q[0]] + 1 <= most && acc[q[0] + 1] >= least
    }
}