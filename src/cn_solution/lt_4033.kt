package cn_solution

import kotlin.random.Random

fun validSubarrays(nums: IntArray, k: Int, queries: Array<IntArray>): BooleanArray {
    val n = nums.size
    val map = HashMap<Int, Long>()
    val pre = LongArray(n + 1)
    for (i in nums.indices) {
        val x = map.getOrPut(nums[i]) { Random.nextLong() }
        pre[i + 1] = pre[i] xor x
    }
    val left = HashMap<Int, Int>()
    val right = HashMap<Int, Int>()
    var l = 0
    var r = 0
    val itv = Array(n) { IntArray(2) }
    for (i in nums.indices) {
        val x = nums[i]
        left.merge(x, 1, Int::plus)
        while (left.size > k)
            left.merge(nums[l++], -1) { a, b ->
                if (a + b == 0) null else a + b
            }
        right.merge(x, 1, Int::plus)
        while (right.size >= k)
            right.merge(nums[r++], -1) { a, b ->
                if (a + b == 0) null else a + b
            }
        itv[i][0] = l
        itv[i][1] = r
    }
    return BooleanArray(queries.size) { i ->
        val (l, r) = queries[i]
        pre[r + 1] == pre[l] && l in itv[r][0] until itv[r][1]
    }
}