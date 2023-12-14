package cn_solution

fun numberOfGoodPartitions(nums: IntArray): Int {
    val rightmost = nums.indices.associateByTo(HashMap()) { nums[it] }
    var result = 1
    val mod = 1000000007
    var r = 0
    nums.forEachIndexed { i, n ->
        if (i > r)
            result = result * 2 % mod
        r = maxOf(r, rightmost[n]!!)
    }
    return result
}