package cn_solution

private fun minimumOperations(nums: IntArray): Int {
    val set = HashSet<Int>()
    for (i in nums.indices.reversed())
        if (!set.add(nums[i]))
            break
    return (nums.size - set.size + 2) / 3
}