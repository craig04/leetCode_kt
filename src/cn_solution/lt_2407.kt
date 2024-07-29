package cn_solution

fun lengthOfLIS(nums: IntArray, k: Int): Int {

    class Node {
        var value = 0
        var low = 0
        var high = 0
        var left = 0
        var right = 0
    }

    var low = Int.MAX_VALUE
    var high = Int.MIN_VALUE
    for (num in nums) {
        low = minOf(low, num)
        high = maxOf(high, num)
    }
    val nodes = Array((high - low) * 2 + 1) { Node() }
    var pos = 0
    fun build(low: Int, high: Int): Int {
        val idx = pos++
        val it = nodes[idx]
        it.value = 0
        it.low = low
        it.high = high
        if (low != high) {
            val mid = (low + high) shr 1
            it.left = build(low, mid)
            it.right = build(mid + 1, high)
        }
        return idx
    }

    fun query(idx: Int, low: Int, high: Int): Int {
        val it = nodes[idx]
        if (it.low == low && it.high == high)
            return it.value
        val mid = (it.low + it.high) shr 1
        var ans = Int.MIN_VALUE
        if (low <= mid)
            ans = maxOf(ans, query(it.left, low, minOf(mid, high)))
        if (high > mid)
            ans = maxOf(ans, query(it.right, maxOf(low, mid + 1), high))
        return ans
    }

    fun update(idx: Int, key: Int, value: Int) {
        val it = nodes[idx]
        if (it.low == it.high && it.low == key) {
            it.value = maxOf(it.value, value)
        } else {
            val mid = (it.low + it.high) shr 1
            val child = if (key <= mid) it.left else it.right
            update(child, key, value)
            it.value = maxOf(it.value, nodes[child].value)
        }
    }
    build(low, high)
    return nums.maxOf { num ->
        if (num != low) {
            val len = query(0, maxOf(low, num - k), num - 1)
            update(0, num, len + 1)
        } else {
            update(0, num, 1)
        }
        query(0, num, num)
    }
}