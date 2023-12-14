package cn_solution

class Solution_2944 {
    fun minOperations(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        fun calculate(): Int {
            val e1 = nums1.last()
            val e2 = nums2.last()
            return nums1.indices.count {
                when {
                    nums1[it] <= e1 && nums2[it] <= e2 -> false
                    nums1[it] <= e2 && nums2[it] <= e1 -> true
                    else -> return n
                }
            }
        }

        val result = calculate()
        val exchange = nums1[n - 1]
        nums1[n - 1] = nums2[n - 1]
        nums2[n - 1] = exchange
        return minOf(result, 1 + calculate()).let { if (it >= n) -1 else it }
    }
}