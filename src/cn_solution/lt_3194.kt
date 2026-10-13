package cn_solution

fun minimumAverage(nums: IntArray): Double {
    nums.sort()
    var i = 0
    var j = nums.lastIndex
    var sum = Int.MAX_VALUE
    while (i < j)
        sum = minOf(sum, nums[i++] + nums[j--])
    return sum / 2.0
}