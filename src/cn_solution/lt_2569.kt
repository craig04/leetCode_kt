package cn_solution

fun handleQuery(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): LongArray {
    val tree = Tree(nums1)
    var sum1 = 0L
    var sum2 = 0L
    val result = ArrayList<Long>()
    for (i in nums1.indices) {
        sum1 += nums1[i]
        sum2 += nums2[i]
    }
    for ((a, b, c) in queries) {
        when (a) {
            1 -> sum1 += tree.update(0, b, c)
            2 -> sum2 += b * sum1
            3 -> result.add(sum2)
        }
    }
    return LongArray(result.size) { result[it] }
}

class Tree(nums: IntArray) {

    private class Node(
        var left: Int = 0,
        var right: Int = 0,
        var count: Int = 0,
        var lazy: Boolean = false
    )

    private val nodes = Array(nums.size * 4) { Node() }

    init {
        fun build(i: Int, l: Int, r: Int): Int {
            nodes[i].left = l
            nodes[i].right = r
            nodes[i].count = if (l == r)
                nums[r]
            else {
                val mid = (l + r) shr 1
                val j = i shl 1
                build(j + 1, l, mid) + build(j + 2, mid + 1, r)
            }
            return nodes[i].count
        }
        build(0, 0, nums.lastIndex)
    }

    fun update(i: Int, l: Int, r: Int): Int {
        nodes[i].apply {
            val old = count
            if (left == l && right == r) {
                lazy = !lazy
                count = (r - l + 1) - count
                return count - old
            }
            val mid = (left + right) shr 1
            val j = i shl 1
            if (lazy) {
                lazy = false
                update(j + 1, left, mid)
                update(j + 2, mid + 1, right)
            }
            if (l <= mid)
                count += update(j + 1, l, minOf(mid, r))
            if (r > mid)
                count += update(j + 2, maxOf(l, mid + 1), r)
            return count - old
        }
    }
}