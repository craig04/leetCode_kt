package cn_solution

private fun countSpecialIntegers(nums: IntArray): Int {
    return nums.indices.groupBy { nums[it] }.values.count { pos ->
        if (pos.size < 3)
            return@count false
        val d = pos[1] - pos[0]
        (2 until pos.size).all { pos[it] - pos[it - 1] == d }
    }
}