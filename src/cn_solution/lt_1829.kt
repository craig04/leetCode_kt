package cn_solution

fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
    var x = nums.reduce(Int::xor)
    val mask = 1.shl(maximumBit) - 1
    return IntArray(nums.size) { i ->
        val res = x xor mask
        x = x xor nums[nums.lastIndex - i]
        res
    }
}