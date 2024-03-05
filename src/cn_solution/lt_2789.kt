package cn_solution

fun maxArrayValue(nums: IntArray): Long {
    var last = 0L
    var result = 0L
    for (i in nums.indices.reversed()) {
        val num = nums[i]
        if (num > last)
            last = 0
        last += num
        result = maxOf(result, last)
    }
    return result
}