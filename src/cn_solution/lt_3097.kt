package cn_solution

private fun minimumSubarrayLength_logTrick(nums: IntArray, k: Int): Int {
    var ans = Int.MAX_VALUE
    nums.forEachIndexed { i, x ->
        if (x >= k)
            return 1
        for (j in i - 1 downTo 0) {
            val s = nums[j] or x
            if (s == nums[j])
                break
            nums[j] = s
            if (s >= k)
                ans = minOf(ans, i - j + 1)
        }
    }
    return if (ans == Int.MAX_VALUE) -1 else ans
}

private fun minimumSubarrayLength_slidingWindow(nums: IntArray, k: Int): Int {
    var ans = Int.MAX_VALUE
    var right = 0
    var l = 0
    var m = 0
    nums.forEachIndexed { r, x ->
        right = right or x
        while (l <= r && right or nums[l] >= k) {
            ans = minOf(ans, r - l + 1)
            if (++l > m) {
                m = r
                for (t in r - 1 downTo l)
                    nums[t] = nums[t] or nums[t + 1]
                right = 0
            }
        }

    }
    return if (ans == Int.MAX_VALUE) -1 else ans
}