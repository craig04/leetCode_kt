package cn_solution

fun findValidElements(nums: IntArray): List<Int> {
    val yes = BooleanArray(nums.size)
    var max = 0
    for (i in nums.indices.reversed()) {
        yes[i] = nums[i] > max
        max = maxOf(max, nums[i])
    }
    val ans = ArrayList<Int>()
    max = 0
    for (i in nums.indices) {
        if (nums[i] > max || yes[i])
            ans += nums[i]
        max = maxOf(max, nums[i])
    }
    return ans
}