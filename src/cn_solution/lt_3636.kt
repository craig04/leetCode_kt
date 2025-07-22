package cn_solution

import java.util.*
import kotlin.math.sqrt

fun subarrayMajority(nums: IntArray, queries: Array<IntArray>): IntArray {
    val block = maxOf(1, (nums.size / sqrt(queries.size + 0.0)).toInt())
    val query = Array(queries.size) {
        val (l, r, threshold) = queries[it]
        intArrayOf(l, r, threshold, l / block, it)
    }
    query.sortWith { a, b -> if (a[3] == b[3]) a[1] - b[1] else a[3] - b[3] }
    val ans = IntArray(queries.size) { -1 }
    var i = 0
    val f = HashMap<Int, TreeSet<Int>>()
    val cnt = HashMap<Int, Int>()
    var max = 0
    var left = 0
    var right = 0
    fun add(x: Int) {
        val old = cnt[x] ?: 0
        val new = old + 1
        if (old != 0)
            f[old]?.remove(x)
        cnt[x] = new
        f.computeIfAbsent(new) { TreeSet() }.add(x)
        max = maxOf(max, new)
    }

    fun del(x: Int) {
        val old = cnt[x] ?: 0
        val new = old - 1
        f[old]?.run {
            remove(x)
            if (isEmpty())
                f.remove(old)
        }
        cnt[x] = new
        f.computeIfAbsent(new) { TreeSet() }.add(x)
        if (max !in f)
            max = new
    }
    for (j in query.indices) {
        val (l, r, threshold, b, t) = query[j]
        if (b != query[i][3]) {
            i = j
            f.clear()
            cnt.clear()
            max = 0
            left = l
            right = l
        }
        while (right <= r)
            add(nums[right++])
        while (left < l)
            del(nums[left++])
        while (left > l)
            add(nums[--left])
        if (max >= threshold)
            ans[t] = f[max]?.firstOrNull() ?: 0
    }
    return ans
}