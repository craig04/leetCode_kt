package cn_solution

fun smallestBalancedIndex(nums: IntArray): Int {
    var sum = nums.fold(0L, Long::plus)
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