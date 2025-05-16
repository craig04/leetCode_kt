package cn_solution

private fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
    val n = nums.size
    var s = 0
    val d = IntArray(n + 1)
    var j = 0
    for (i in nums.indices) {
        val num = nums[i]
        s += d[i]
        while (s < num && j < queries.size) {
            val (l, r, x) = queries[j++]
            d[l] += x
            d[r + 1] -= x
            if (i in l..r)
                s += x
        }
        if (s < num)
            return -1
    }
    return j
}