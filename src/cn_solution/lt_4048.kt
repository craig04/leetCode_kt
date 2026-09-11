package cn_solution

private fun countSpecialIntegers(nums: IntArray): Int {
    return nums.indices.groupBy { nums[it] }.values.count {
        it.size == 3 && it[0] + it[2] == it[1] * 2
    }
}