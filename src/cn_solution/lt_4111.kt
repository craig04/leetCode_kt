package cn_solution

private fun countConsistent(nums: IntArray): Int {
    return nums.indices.sumOf { i ->
        var min = Int.MAX_VALUE
        var sum = Int.MAX_VALUE
        (i until nums.size).count { j ->
            min = minOf(min, nums[j])
            sum = sum and nums[j]
            min == sum
        }
    }
}