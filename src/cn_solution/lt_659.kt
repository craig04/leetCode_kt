package cn_solution

import java.util.*

/**
 * O(n * log(n)) time complexity
 */
private fun isPossible_priorityQueue(nums: IntArray): Boolean {
    val map = HashMap<Int, PriorityQueue<Int>>()
    for (num in nums) {
        val len = 1 + (map[num - 1]?.poll() ?: 0)
        map.computeIfAbsent(num) { PriorityQueue() }.add(len)
    }
    return map.values.all { it.isEmpty() || it.poll() >= 3 }
}


/**
 * O(n) time complexity
 */
private fun isPossible_greedy(nums: IntArray): Boolean {
    val n = nums.size
    var pre = Int.MIN_VALUE
    var x = 0
    var y = 0
    var z = 0
    var i = 0
    while (i != n) {
        var j = i + 1
        while (j != n && nums[i] == nums[j])
            j++
        val cnt = j - i
        if (nums[i] != pre + 1) {
            if (x or y != 0)
                return false
            x = cnt
            y = 0
            z = 0
        } else if (cnt < x + y) {
            return false
        } else {
            val more = cnt - x - y
            val keep = minOf(more, z)
            z = y + keep
            y = x
            x = more - keep
        }
        pre = nums[i]
        i = j
    }
    return x or y == 0
}