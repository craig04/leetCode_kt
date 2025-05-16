package cn_solution

import java.util.*

fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
    val set = TreeSet<Long>()
    var sum = 0L
    set.add(0L)
    for (i in nums.indices) {
        sum += nums[i]
        set.add(sum)
    }
    val map = HashMap<Long, Int>()
    set.forEachIndexed { i, s -> map[s] = i + 1 }
    val a = IntArray(nums.size + 2)
    fun update(i: Int) {
        var j = i
        while (j < a.size) {
            a[j]++
            j += j and -j
        }
    }

    fun query(i: Int): Int {
        var ans = 0
        var j = i
        while (j > 0) {
            ans += a[j]
            j = j and (j - 1)
        }
        return ans
    }

    var ans = 0
    sum = 0L
    update(map[0]!!)
    for (i in nums.indices) {
        sum += nums[i]
        val x = set.ceiling(sum - upper)
        val y = set.floor(sum - lower)
        if (x != null && y != null && x <= y) {
            ans += query(map[y]!!) - query(map[x]!! - 1)
        }
        update(map[sum]!!)
    }
    return ans
}