package cn_solution

fun semiOrderedPermutation(nums: IntArray): Int {
    val n = nums.size
    var a = 0
    var b = 0
    for (i in nums.indices) {
        when (nums[i]) {
            1 -> a = i
            n -> b = i
        }
    }
    var ans = a + n - 1 - b
    if (a > b)
        ans--
    return ans
}