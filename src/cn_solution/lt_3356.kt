package cn_solution

private fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
    var l = 0
    var r = queries.size + 1
    val n = nums.size
    val diff = IntArray(n + 1)
    while (l != r) {
        val m = (l + r) shr 1
        diff.fill(0)
        (0 until m).forEach {
            val q = queries[it]
            diff[q[0]] += q[2]
            diff[q[1] + 1] -= q[2]
        }
        var pre = 0
        if (nums.indices.all {
                pre += diff[it]
                pre >= nums[it]
            })
            r = m
        else
            l = m + 1
    }
    return if (l > queries.size) -1 else l
}