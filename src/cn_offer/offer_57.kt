package cn_offer

fun twoSum(nums: IntArray, target: Int): IntArray {
    var l = 0
    var r = nums.lastIndex
    while (l < r) {
        val sum = nums[l] + nums[r]
        when {
            target > sum -> l++
            target < sum -> r--
            else -> return intArrayOf(nums[l], nums[r])
        }
    }
    return IntArray(0)
}