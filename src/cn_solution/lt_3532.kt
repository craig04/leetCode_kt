package cn_solution

private fun pathExistenceQueries(n: Int, nums: IntArray, maxDiff: Int, queries: Array<IntArray>): BooleanArray {
    val idx = IntArray(n)
    for (i in 1 until nums.size) {
        idx[i] = idx[i - 1]
        if (nums[i] - nums[i - 1] > maxDiff)
            idx[i]++
    }
    return BooleanArray(queries.size) {
        val (x, y) = queries[it]
        idx[x] == idx[y]
    }
}