package cn_solution

fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
    val n = nums.size
    val diff = IntArray(n + 1)
    queries.forEach { (l, r) ->
        diff[l]++
        diff[r + 1]--
    }
    var cur = 0
    return nums.indices.all {
        cur += diff[it]
        cur >= nums[it]
    }
}