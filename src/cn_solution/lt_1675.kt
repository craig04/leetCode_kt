package cn_solution

import java.util.PriorityQueue

fun minimumDeviation(nums: IntArray): Int {
    val q = PriorityQueue<Int>(reverseOrder())
    var min = Int.MAX_VALUE
    for (num in nums) {
        var cur = num
        if (cur and 1 == 1)
            cur *= 2
        q.add(cur)
        min = minOf(min, cur)
    }
    var ans = Int.MAX_VALUE
    do {
        var cur = q.poll()
        ans = minOf(ans, cur - min)
        if (cur and 1 == 1)
            break
        cur /= 2
        q.add(cur)
        min = minOf(min, cur)
    } while (true)
    return ans
}