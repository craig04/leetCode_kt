package cn_solution

private fun uniqueXorTriplets(nums: IntArray): Int {
    val n = nums.size
    return if (n > 2) n.takeHighestOneBit() * 2 else n
}