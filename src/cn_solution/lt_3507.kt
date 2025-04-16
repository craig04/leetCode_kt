package cn_solution

private fun minimumPairRemoval(nums: IntArray): Int {
    var len = nums.size
    while (len > 1) {
        var sum = Int.MAX_VALUE
        var pos = -1
        var increasing = true
        for (i in 1 until len) {
            if (nums[i - 1] + nums[i] < sum) {
                sum = nums[i - 1] + nums[i]
                pos = i
            }
            if (nums[i - 1] > nums[i])
                increasing = false
        }
        if (increasing)
            break
        nums[pos - 1] = sum
        nums.copyInto(nums, pos, pos + 1, len--)
    }
    return nums.size - len
}