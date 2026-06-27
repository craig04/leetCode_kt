package cn_solution

fun maxValidPairSum(nums: IntArray, k: Int): Int {
    var max = Int.MIN_VALUE
    var ans = 0
    for (i in k until nums.size) {
        max = maxOf(max, nums[i - k])
        ans = maxOf(ans, nums[i] + max)
    }
    return ans
}