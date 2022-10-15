package cn_solution

fun maxAscendingSum(nums: IntArray): Int {
    var i = 0
    var result = 0
    while (i != nums.size) {
        var sum = nums[i++]
        while (i != nums.size && nums[i] > nums[i - 1])
            sum += nums[i++]
        result = maxOf(sum, result)
    }
    return result
}
