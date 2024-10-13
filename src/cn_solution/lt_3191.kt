package cn_solution

private fun minOperations(nums: IntArray): Int {
    fun IntArray.rev(t: Int) {
        nums[t] = 1 - nums[t]
    }

    val n = nums.size
    var ans = 0
    for (i in 0 until n - 2) {
        if (nums[i] == 0) {
            nums.rev(i)
            nums.rev(i + 1)
            nums.rev(i + 2)
            ans++
        }
    }
    return if (nums[n - 2] + nums[n - 1] == 2) ans else -1
}