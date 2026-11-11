package cn_solution

fun countDominantElements(nums: IntArray): Int {
    val n = nums.size
    if (n == 1)
        return 1
    var ans = (1 until n - 1).count { i ->
        nums[i] * 2 >= nums[i - 1] + nums[i + 1]
    }
    if (nums[0] >= nums[1])
        ans++
    if (nums[n - 1] >= nums[n - 2])
        ans++
    return ans
}