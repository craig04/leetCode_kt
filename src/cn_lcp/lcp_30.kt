package cn_lcp

import java.util.PriorityQueue

fun magicTower(nums: IntArray): Int {
    val q = PriorityQueue<Int>()
    var hit = 1L
    var sub = 0L
    var result = 0
    for (num in nums) {
        hit += num
        if (num < 0)
            q.offer(num)
        if (hit <= 0) {
            val tmp = q.poll()
            hit -= tmp
            sub -= tmp
            result++
        }
    }
    return if (hit > sub) result else -1
}