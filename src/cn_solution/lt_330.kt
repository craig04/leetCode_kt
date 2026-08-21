package cn_solution

fun minPatches(nums: IntArray, n: Int): Int {
    val len = nums.size
    var x = 1L
    var i = 0
    var ans = 0
    while (x <= n) {
        if (i == len || nums[i] > x) {
            x *= 2
            ans++
        } else if (nums[i] <= x) {
            x += nums[i++]
        }
    }
    return ans
}