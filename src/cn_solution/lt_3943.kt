package cn_solution

import kotlin.math.sqrt

fun numberOfPairs(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): IntArray {
    val n = nums1.size
    val m = nums2.size
    val len = sqrt(1.0 * n * m).toInt()
    val cnt = (m + len - 1) / len
    val map = Array(cnt) { HashMap<Int, Int>() }
    val inc = IntArray(cnt)
    for (i in 0 until m)
        map[i / len].merge(nums2[i], 1, Int::plus)
    val ans = ArrayList<Int>()
    for (q in queries) {
        if (q[0] == 1) {
            val (_, x, y, `val`) = q
            for (i in x / len until cnt) {
                val l = i * len
                val r = l + len - 1
                if (l > y)
                    break
                else if (x <= l && y >= r)
                    inc[i] += `val`
                else for (j in maxOf(l, x)..minOf(r, y)) {
                    map[i].merge(nums2[j], -1, Int::plus)
                    nums2[j] += `val`
                    map[i].merge(nums2[j], 1, Int::plus)
                }
            }
        } else {
            val tot = q[1]
            ans.add(nums1.sumOf { x ->
                map.indices.sumOf { i -> map[i][tot - x - inc[i]] ?: 0 }
            })
        }
    }
    return ans.toIntArray()
}