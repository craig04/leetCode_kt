package cn_offer

fun isStraight(nums: IntArray): Boolean {
    nums.sort()
    var joker = 0
    for (i in 0 until 4) {
        if (nums[i] == 0)
            joker++
        else if (nums[i] == nums[i + 1])
            return false
    }
    return nums[4] - nums[joker] < 5
}