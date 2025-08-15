package cn_solution

import kotlin.math.sqrt

fun subarrayMajority(nums: IntArray, queries: Array<IntArray>): IntArray {
    val n = nums.size
    val block = maxOf(1, (n / sqrt(queries.size + 0.0)).toInt())
    val q = Array((n + block - 1) / block) { ArrayList<Int>() }
    val ans = IntArray(queries.size) { -1 }
    val freq = HashMap<Int, Int>()
    var max = 0
    var num = 0
    fun add(x: Int) {
        val f = freq.merge(x, 1, Int::plus) ?: 0
        if (f > max || f == max && x < num) {
            max = f
            num = x
        }
    }
    for (i in queries.indices) {
        val l = queries[i][0] / block
        val r = queries[i][1] / block
        if (l != r) {
            q[l].add(i)
            continue
        }
        freq.clear()
        max = 0
        for (j in queries[i][0]..queries[i][1])
            add(nums[j])
        if (max >= queries[i][2])
            ans[i] = num
    }
    for (i in q.indices) {
        q[i].sortBy { queries[it][1] }
        freq.clear()
        max = 0
        val pivot = (i + 1) * block
        var left = pivot
        var right = pivot - 1
        for (j in q[i]) {
            val (l, r, threshold) = queries[j]
            while (right < r)
                add(nums[++right])
            val a = max
            val b = num
            while (left > l)
                add(nums[--left])
            if (max >= threshold)
                ans[j] = num
            while (left < pivot)
                freq.merge(nums[left++], -1, Int::plus)
            max = a
            num = b
        }
    }
    return ans
}