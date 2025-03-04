package cn_solution

fun waysToPartition(nums: IntArray, k: Int): Int {
    val map = HashMap<Long, Int>()
    var sum = 0L
    for (num in nums) {
        sum += num
        map.merge(sum, 1, Int::plus)
    }
    var ans = 0
    if (sum % 2 == 0L)
        ans = map[sum / 2] ?: 0
    if (sum == 0L)
        ans--
    var p = sum
    var s = 0L
    for (i in nums.indices.reversed()) {
        map.merge(p, -1, Int::plus)
        p -= nums[i]
        sum += k - nums[i]
        if (sum % 2 == 0L)
            ans = maxOf(ans, map[sum / 2] ?: 0)
        sum -= k - nums[i]
        s += nums[i]
        map.merge(s, 1, Int::plus)
    }
    return ans
}