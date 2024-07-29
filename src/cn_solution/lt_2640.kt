package cn_solution

fun findPrefixScore(nums: IntArray): LongArray {
    var max = 0
    var sum = 0L
    return LongArray(nums.size) {
        max = maxOf(max, nums[it])
        sum += nums[it] + max
        sum
    }
}