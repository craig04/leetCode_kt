package cn_solution

fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
    val acc = IntArray(nums.size)
    var pre = nums[0] and 1
    for (i in 1 until nums.size) {
        val cur = nums[i] and 1
        acc[i] = acc[i - 1] + 1 - pre.xor(cur)
        pre = cur
    }
    return BooleanArray(queries.size) {
        val q = queries[it]
        acc[q[1]] == acc[q[0]]
    }
}