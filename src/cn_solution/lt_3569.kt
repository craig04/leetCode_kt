package cn_solution

import java.util.*

fun maximumCount(nums: IntArray, queries: Array<IntArray>): IntArray {
    val s = BooleanArray(100001) { true }
    s[1] = false
    var p = 2
    while (p * p <= s.size) {
        if (s[p])
            for (q in p * p until s.size step p)
                s[q] = false
        p++
    }
    val pos = HashMap<Int, TreeSet<Int>>()
    for (i in nums.indices)
        if (s[nums[i]])
            pos.computeIfAbsent(nums[i]) { TreeSet() }.add(i)
    val n = nums.size
    val a = IntArray(n * 4)
    val b = IntArray(n * 4)

    fun update(i: Int, l: Int, r: Int, x: Int, y: Int, d: Int) {
        if (l == x && r == y) {
            b[i] += d
            return
        }
        val j = i * 2 + 1
        val k = i * 2 + 2
        if (b[i] != 0) {
            a[i] += b[i]
            b[j] += b[i]
            b[k] += b[i]
            b[i] = 0
        }
        val m = (l + r) / 2
        if (x <= m)
            update(j, l, m, x, minOf(y, m), d)
        if (y > m)
            update(k, m + 1, r, maxOf(x, m + 1), y, d)
        a[i] = maxOf(a[j] + b[j], a[k] + b[k])
    }
    for (set in pos.values)
        if (set.size > 1)
            update(0, 0, n - 2, set.first(), set.last() - 1, 1)
    return IntArray(queries.size) {
        val (idx, num) = queries[it]
        val pre = nums[idx]
        nums[idx] = num
        if (pre != num) {
            pos[pre]?.run {
                when {
                    size == 1 -> pos.remove(pre)
                    idx == first() -> {
                        remove(idx)
                        update(0, 0, n - 2, idx, first() - 1, -1)
                    }
                    idx == last() -> {
                        remove(idx)
                        update(0, 0, n - 2, last(), idx - 1, -1)
                    }
                    else -> remove(idx)
                }
            }
            if (s[num]) {
                pos.computeIfAbsent(num) { TreeSet() }.run {
                    if (isEmpty())
                        add(idx)
                    else if (size == 1) {
                        add(idx)
                        update(0, 0, n - 2, first(), last() - 1, 1)
                    } else if (size > 1) {
                        if (idx < first())
                            update(0, 0, n - 2, idx, first() - 1, 1)
                        else if (idx > last())
                            update(0, 0, n - 2, last(), idx - 1, 1)
                        add(idx)
                    }
                }
            }
        }
        pos.size + a[0] + b[0]
    }
}