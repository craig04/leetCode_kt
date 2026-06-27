package cn_solution

fun missingInteger(nums: IntArray): Int {
    var pre = true
    var sum = nums.first()
    val set = hashSetOf(sum)
    for (i in 1 until nums.size) {
        if (nums[i] - nums[i - 1] != 1)
            pre = false
        else if (pre)
            sum += nums[i]
        set += nums[i]
    }
    return (sum..Int.MAX_VALUE).first { it !in set }
}