package cn_solution

fun countValidSelections(nums: IntArray): Int {
    val sum = nums.sum()
    var pre = 0
    var ans = 0
    for (num in nums) {
        if (num != 0) {
            pre += num
        } else {
            val diff = sum - pre - pre
            if (diff <= -2)
                break
            else if (diff < 2)
                ans += 2 - kotlin.math.abs(diff)
        }
    }
    return ans
}