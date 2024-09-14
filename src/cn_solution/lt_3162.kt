package cn_solution

private fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Int {
    return nums2.sumOf { num2 ->
        val divisor = num2 * k
        nums1.count { it % divisor == 0 }
    }
}