package cn_solution

private fun minOperations(nums: IntArray, target: IntArray): Int {
    val set = HashSet<Int>()
    for (i in nums.indices)
        if (nums[i] != target[i])
            set += nums[i]
    return set.size
}