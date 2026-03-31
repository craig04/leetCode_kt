package cn_solution

fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
    for ((l, r, k, v) in queries)
        for (i in l..r step k)
            nums[i] = (nums[i] * 1L * v).mod(1000000007)
    return nums.reduce(Int::xor)
}