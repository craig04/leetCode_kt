package cn_offer

import java.util.*
import kotlin.collections.HashMap

/**
 * Solution using merge sort
 */
fun reversePairs(nums: IntArray): Int {
    val temp = IntArray(nums.size)
    fun count(left: Int, right: Int): Int {
        if (left == right)
            return 0
        val mid = (left + right) shr 1
        val sub = count(left, mid) + count(mid + 1, right)
        var r = mid + 1
        var p = 0
        var self = 0
        for (l in left..mid) {
            while (r <= right && nums[l] > nums[r])
                temp[p++] = nums[r++]
            self += r - mid - 1
            temp[p++] = nums[l]
        }
        temp.copyInto(nums, left, 0, p)
        return sub + self
    }
    return count(0, nums.lastIndex)
}

/**
 * Solution using binary indexed tree
 */
fun reversePairs_2(nums: IntArray): Int {
    val indices = HashMap<Int, Int>()
    var size = 0
    TreeSet(nums.asList()).forEach { indices[it] = ++size }
    val a = IntArray(size + 1)
    fun update(n: Int) {
        var m = n
        while (m <= size) {
            a[m]++
            val lowest = m and -m
            m += lowest
        }
    }

    fun query(n: Int): Int {
        var m = n
        var result = 0
        while (m != 0) {
            result += a[m]
            val lowest = m and -m
            m -= lowest
        }
        return result
    }

    var result = 0
    nums.forEachIndexed { i, n ->
        val index = indices[n] ?: 0
        result += i - query(index)
        update(index)
    }
    return result
}