package cn_solution

fun matrixSum(nums: Array<IntArray>): Int {
    nums.forEach { it.sort() }
    return nums[0].indices.sumBy { j ->
        nums.indices.fold(0) { acc, i ->
            maxOf(acc, nums[i][j])
        }
    }
}