package cn_solution

private fun countQuadruplets(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    var ans = 0
    for (b in nums.size - 3 downTo 1) {
        for (d in nums.size - 1 downTo b + 1)
            map.merge(nums[d] - nums[b + 1], 1, Int::plus)
        for (a in b - 1 downTo 0)
            ans += map[nums[b] + nums[a]] ?: 0
    }
    return ans
}