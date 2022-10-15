package cn_solution

fun jump(nums: IntArray): Int {
    var result = 0
    var step = 0
    var furthest = 0
    for (i in nums.indices) {
        furthest = maxOf(furthest, i + nums[i])
        if (i == step) {
            step = furthest
            result++
        }
    }
    return result
}
