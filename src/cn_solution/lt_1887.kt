package cn_solution

fun reductionOperations(nums: IntArray): Int {
    nums.sortDescending()
    return (1 until nums.size).sumOf { i ->
        if (nums[i - 1] != nums[i]) i else 0
    }
}