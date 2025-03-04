package cn_solution

fun maximumSegmentSum(nums: IntArray, removeQueries: IntArray): LongArray {
    val n = nums.size
    val p = IntArray(n) { -1 }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    val ans = LongArray(removeQueries.size)
    val sum = LongArray(n)
    var max = 0L
    for (i in removeQueries.indices.reversed()) {
        ans[i] = max
        val x = removeQueries[i]
        var tmp = nums[x] + 0L
        p[x] = x
        if (x < n - 1 && p[x + 1] != -1) {
            p[x + 1] = x
            tmp += sum[x + 1]
        }
        if (x > 0 && p[x - 1] != -1) {
            val y = find(x - 1)
            p[x] = y
            tmp += sum[y]
            sum[y] = tmp
        }
        sum[x] = tmp
        max = maxOf(max, tmp)
    }
    return ans
}