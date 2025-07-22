package cn_solution

fun check(nums: IntArray): Boolean {
    val n = nums.size
    var i = 1
    while (i != n && nums[i - 1] <= nums[i])
        i++
    return i == n || nums[n - 1] <= nums[0] && (i until n - 1).all {
        nums[it] <= nums[it + 1]
    }
}