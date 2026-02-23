package cn_solution

private fun uniformArray(nums1: IntArray): Boolean {
    val min = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)
    for (num in nums1) {
        val bit = num and 1
        min[bit] = minOf(min[bit], num)
    }
    return min[1] == Int.MAX_VALUE || min[0] > min[1]
}