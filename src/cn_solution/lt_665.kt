package cn_solution

fun checkPossibility(nums: IntArray): Boolean {
    var cnt = 0
    for (i in 0 until nums.lastIndex)
        if (nums[i] > nums[i + 1]) {
            if (++cnt == 2)
                return false
            if (i > 0 && nums[i + 1] < nums[i - 1])
                nums[i + 1] = nums[i]
        }
    return true
}