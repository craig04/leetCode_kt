package cn_solution

fun minimumValueSum(nums: IntArray, andValues: IntArray): Int {
    val n = nums.size
    val m = andValues.size
    val map = HashMap<Long, Int>()
    val mask = 1L.shl(32) - 1
    fun dfs(i: Int, j: Int, curr: Int): Int {
        if (j == m)
            return if (i == n) 0 else Int.MAX_VALUE shr 1
        var key = curr.toLong() and mask
        key = key or i.toLong().shl(36)
        key = key or j.toLong().shl(32)
        println()
        return map.getOrPut(key) {
            var result = Int.MAX_VALUE shr 1
            val next = curr and nums[i]
            if (next < andValues[j])
                return@getOrPut result
            if (n - i > m - j)
                result = minOf(result, dfs(i + 1, j, next))
            if (next == andValues[j])
                result = minOf(result, dfs(i + 1, j + 1, -1) + nums[i])
            result
        }
    }

    val result = dfs(0, 0, -1)
    return if (result >= Int.MAX_VALUE shr 1) -1 else result
}