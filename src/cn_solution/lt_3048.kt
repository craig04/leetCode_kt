package cn_solution

fun earliestSecondToMarkIndices(nums: IntArray, changeIndices: IntArray): Int {
    var l = nums.size + nums.sum()
    var r = changeIndices.size + 1
    val vis = IntArray(nums.size)
    while (l < r) {
        val m = (l + r) / 2
        var mark = nums.size
        var decline = 0
        for (i in m - 1 downTo 0) {
            val idx = changeIndices[i] - 1
            if (vis[idx] != m) {
                vis[idx] = m
                mark--
                decline += nums[idx]
            } else if (decline > 0)
                decline--
        }
        if (decline == 0 && mark == 0)
            r = m
        else
            l = m + 1
    }
    return if (l > changeIndices.size) -1 else l
}