package cn_solution

fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
    nums.sort()
    val prefix = IntArray(nums.size + 1)
    nums.forEachIndexed { i, n -> prefix[i + 1] = prefix[i] + n }
    return IntArray(queries.size) {
        val q = queries[it]
        var l = 0
        var r = prefix.lastIndex
        while (l != r) {
            val m = (l + r + 1) shr 1
            when (prefix[m] > q) {
                true -> r = m - 1
                else -> l = m
            }
        }
        r
    }
}