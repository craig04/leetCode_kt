package cn_solution

fun countNonDecreasingSubarrays(nums: IntArray, k: Int): Long {
    val n = nums.size
    val low = Array(n) { ArrayList<Int>() }
    val right = IntArray(nums.size) { n }
    val s = ArrayDeque<Int>()
    nums.forEachIndexed { i, num ->
        while (s.isNotEmpty() && num >= nums[s.last()])
            right[s.removeLast()] = i
        if (s.isNotEmpty())
            low[s.last()].add(i)
        s.addLast(i)
    }
    s.clear()
    var l = 0
    var cnt = 0L
    var ans = 0L
    nums.forEachIndexed { r, num ->
        while (s.isNotEmpty() && num >= nums[s.last()])
            s.removeLast()
        s.addLast(r)
        cnt += nums[s.first()] - num
        while (cnt > k) {
            for (t in low[l]) {
                if (t > r)
                    break
                cnt -= 1L * (nums[l] - nums[t]) * (minOf(r + 1, right[t]) - t)
            }
            if (s.first() == l++)
                s.removeFirst()
        }
        ans += r - l + 1
    }
    return ans
}