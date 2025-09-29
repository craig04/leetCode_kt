package cn_solution

import java.util.*

private fun maxFrequency_differentialArray(nums: IntArray, k: Int, numOperations: Int): Int {
    val cnt = HashMap<Int, Int>()
    val diff = TreeMap<Int, Int>()
    for (num in nums) {
        cnt[num] = (cnt[num] ?: 0) + 1
        diff.putIfAbsent(num, 0)
        diff[num - k] = (diff[num - k] ?: 0) + 1
        diff[num + k + 1] = (diff[num + k + 1] ?: 0) - 1
    }
    var cur = 0
    return diff.maxOf { (k, v) ->
        cur += v
        minOf(cur, (cnt[k] ?: 0) + numOperations)
    }
}

private fun maxFrequency_slidingWindow(nums: IntArray, k: Int, numOperations: Int): Int {
    nums.sort()
    val n = nums.size
    var l = 0
    var x = 0
    var y = 0
    var i = 0
    var ans = 0
    while (i != n) {
        var j = i + 1
        while (j != n && nums[j] == nums[i])
            j++
        while (nums[i] - nums[l] > 2 * k)
            l++
        while (nums[i] - nums[x] > k)
            x++
        while (y != n && nums[y] - nums[i] <= k)
            y++
        val cnt = j - i
        ans = maxOf(
            ans,
            cnt + minOf(y - x - cnt, numOperations),
            minOf(j - l, numOperations)
        )
        i = j
    }
    return ans
}