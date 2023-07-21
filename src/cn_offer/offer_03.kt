package cn_offer

fun findRepeatNumber(nums: IntArray): Int {
    var i = 0
    loop@ while (i != nums.size) {
        when {
            nums[i] == i -> i++
            nums[i] == nums[nums[i]] -> break@loop
            else -> {
                val j = nums[i]
                nums[i] = nums[j]
                nums[j] = j
            }
        }
    }
    return nums[i]
}