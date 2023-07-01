package cn_interview

fun wiggleSort(nums: IntArray): Unit {
    for (i in 1 until nums.size) {
        if ((i and 1 == 1) xor (nums[i - 1] < nums[i])) {
            nums[i] -= nums[i - 1]
            nums[i - 1] += nums[i]
            nums[i] -= nums[i - 1]
            nums[i] = -nums[i]
        }
    }
}