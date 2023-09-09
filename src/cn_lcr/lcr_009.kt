package cn_lcr

fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    var product = 1
    var i = 0
    return nums.indices.sumBy { j ->
        product *= nums[j]
        while (i <= j && product >= k)
            product /= nums[i++]
        j - i + 1
    }
}