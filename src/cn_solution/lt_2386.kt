package cn_solution

import java.util.*

fun kSum(nums: IntArray, k: Int): Long {
    var base = 0L
    for (i in nums.indices) {
        if (nums[i] >= 0)
            base += nums[i]
        else
            nums[i] = -nums[i]
    }
    if (k == 1)
        return base
    nums.sort()
    val q = PriorityQueue<Pair<Long, Int>> { a, b -> a.first.compareTo(b.first) }
    q.offer(Pair(nums[0].toLong(), 0))
    repeat(k - 2) {
        var (sum, i) = q.poll()
        if (i != nums.lastIndex) {
            sum += nums[++i]
            q.offer(Pair(sum - nums[i - 1], i))
            q.offer(Pair(sum, i))
        }
    }
    return base - q.poll().first
}