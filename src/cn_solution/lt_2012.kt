package cn_solution

fun sumOfBeauties(nums: IntArray): Int {
    val max = BooleanArray(nums.size) { true }
    var tmp = Int.MIN_VALUE
    for (i in nums.indices) {
        if (nums[i] <= tmp)
            max[i] = false
        tmp = maxOf(tmp, nums[i])
    }
    var ans = 0
    tmp = nums.last()
    for (i in nums.size - 2 downTo 1) {
        if (nums[i] < tmp && max[i])
            ans += 2
        else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1])
            ans += 1
        tmp = minOf(tmp, nums[i])
    }
    return ans
}