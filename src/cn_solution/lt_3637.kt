package cn_solution

fun isTrionic(nums: IntArray): Boolean {
    if (nums[0] >= nums[1])
        return false
    var pre = -1
    var cnt = 0
    for (i in 1 until nums.lastIndex) {
        val cur = nums[i].compareTo(nums[i + 1])
        when (cur) {
            0 -> return false
            -pre -> if (++cnt > 2) break
        }
        pre = cur
    }
    return cnt == 2
}