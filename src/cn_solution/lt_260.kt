package cn_solution

private fun singleNumber(nums: IntArray): IntArray {
    val x = Integer.lowestOneBit(nums.reduce { a, b -> a xor b })
    val res = intArrayOf(0, 0)
    for (n in nums) {
        val idx = if (n and x == 0) 1 else 0
        res[idx] = res[idx] xor n
    }
    return res
}