package cn_solution

fun canSortArray(nums: IntArray): Boolean {
    var pre = Int.MIN_VALUE
    var i = 0
    while (i != nums.size) {
        val cnt = nums[i].countOneBits()
        var min = nums[i]
        var max = nums[i++]
        while (i != nums.size && nums[i].countOneBits() == cnt) {
            min = minOf(min, nums[i])
            max = maxOf(max, nums[i++])
        }
        if (min < pre)
            return false
        pre = max
    }
    return true
}