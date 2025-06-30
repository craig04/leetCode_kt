package cn_solution

import java.util.*

fun smallestRange_priorityQueue(nums: List<List<Int>>): IntArray {
    val q = PriorityQueue<IntArray> { (a, i), (b, j) -> nums[a][i] - nums[b][j] }
    var max = Int.MIN_VALUE
    for (i in nums.indices) {
        max = maxOf(max, nums[i][0])
        q.offer(intArrayOf(i, 0))
    }
    var low = 0
    var dis = Int.MAX_VALUE
    while (q.size == nums.size) {
        val pos = q.poll()
        val (i, j) = pos
        val len = max - nums[i][j]
        if (len < dis || len == dis && nums[i][j] < low) {
            low = nums[i][j]
            dis = len
        }
        if (++pos[1] != nums[i].size) {
            max = maxOf(max, nums[i][j + 1])
            q.offer(pos)
        }
    }
    return intArrayOf(low, low + dis)
}

fun smallestRange_slidingWindow(nums: List<List<Int>>): IntArray {
    val list = nums.indices.fold(ArrayList<IntArray>()) { res, i ->
        nums[i].mapTo(res) { intArrayOf(it, i) }
    }
    list.sortBy { it[0] }
    var low = 0
    var high = Int.MAX_VALUE
    var cnt = 0
    val freq = IntArray(nums.size)
    var i = 0
    for (j in list.indices) {
        if (++freq[list[j][1]] == 1)
            cnt++
        if (cnt != nums.size)
            continue
        while (freq[list[i][1]] > 1)
            freq[list[i++][1]]--
        if (list[j][0] - list[i][0] < high - low) {
            low = list[i][0]
            high = list[j][0]
        }
    }
    return intArrayOf(low, high)
}