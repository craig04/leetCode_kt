package cn_solution

import java.util.*

private fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
    val comparator: Comparator<IntArray> = Comparator { a, b ->
        if (a[0] == b[0]) a[1].compareTo(b[1]) else a[0].compareTo(b[0])
    }
    val max = TreeSet(comparator)
    val min = TreeSet(comparator)
    val cnt = HashMap<Int, Int>()
    var sum = 0
    val ans = IntArray(nums.size - k + 1)
    fun modify(num: Int, diff: Int) {
        val old = cnt.remove(num) ?: 0
        var a = intArrayOf(old, num)
        if (max.remove(a))
            sum -= old * num
        else
            min.remove(a)
        val new = old + diff
        if (new != 0) {
            cnt[num] = new
            a = intArrayOf(new, num)
            if (max.isNotEmpty() && comparator.compare(a, max.first()) == 1) {
                max.add(a)
                sum += new * num
            } else {
                min.add(a)
            }
        }
        if (max.size > x) {
            a = max.pollFirst()!!
            sum -= a[0] * a[1]
            min.add(a)
        } else if (max.size < x && min.isNotEmpty()) {
            a = min.pollLast()!!
            sum += a[0] * a[1]
            max.add(a)
        }
    }
    for (r in nums.indices) {
        val cur = nums[r]
        modify(cur, 1)
        val l = r - k + 1
        if (l < 0)
            continue
        ans[l] = sum
        val pre = nums[l]
        modify(pre, -1)
    }
    return ans
}