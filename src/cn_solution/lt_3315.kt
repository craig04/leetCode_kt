package cn_solution

private fun minBitwiseArray(nums: List<Int>): IntArray {
    return IntArray(nums.size) {
        val num = nums[it]
        if (num and 1 == 0)
            return@IntArray -1
        num.inv().takeLowestOneBit().shr(1).xor(num)
    }
}