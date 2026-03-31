package cn_solution

private fun minOperations(nums: IntArray, k: Int): Int {
    return nums.reduce(Int::xor).xor(k).countOneBits()
}