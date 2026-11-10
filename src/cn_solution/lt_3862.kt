package cn_solution

fun smallestBalancedIndex(nums: IntArray): Int {
    var sum = nums.sumOf(Int::toLong)
    var mul = 1L
    var ans = -1
    for (i in nums.indices.reversed()) {
        sum -= nums[i]
        if (sum == mul)
            ans = i
        if (mul > sum / nums[i])
            break
        mul *= nums[i]
    }
    return ans
}