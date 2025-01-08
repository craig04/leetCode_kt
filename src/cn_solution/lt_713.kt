package cn_solution

fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    var product = 1
    var i = 0
    return nums.indices.sumOf { j ->
        product *= nums[j]
        while (i <= j && product >= k)
            product /= nums[i++]
        j - i + 1
    }
}