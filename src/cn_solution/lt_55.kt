package cn_solution

fun canJump(nums: IntArray): Boolean {
    var furthest = 0
    var i = 0
    while (i <= furthest) {
        furthest = maxOf(furthest, i + nums[i])
        if (furthest >= nums.lastIndex)
            return true
        i++
    }
    return false
}
