package cn_solution

class NumArray(val nums: IntArray) {

    class Node(
        var l: Int = 0,
        var r: Int = 0,
        var v: Int = 0,
        var lc: Int = -1,
        var rc: Int = -1,
    )

    private val nodes = Array(nums.size * 2 - 1) { Node() }.also {
        var temp = 0
        fun build(l: Int, r: Int): Int {
            val idx = temp++
            val cur = it[idx]
            cur.l = l
            cur.r = r
            if (l != r) {
                val m = (l + r) shr 1
                cur.lc = build(l, m)
                cur.rc = build(m + 1, r)
                cur.v = it[cur.lc].v + it[cur.rc].v
            } else {
                cur.v = nums[l]
            }
            return idx
        }
        build(0, nums.lastIndex)
    }

    fun update(index: Int, `val`: Int) {
        val delta = `val` - nums[index]
        nums[index] = `val`
        var temp = 0
        while (temp != -1) {
            val node = nodes[temp]
            node.v += delta
            val m = (node.l + node.r) shr 1
            temp = if (index <= m) node.lc else node.rc
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        fun sumRange(left: Int, right: Int, cur: Int): Int {
            val node = nodes[cur]
            if (node.l == left && node.r == right) {
                return node.v
            }
            val m = (node.l + node.r) shr 1
            var sum = 0
            if (left <= m) sum += sumRange(left, minOf(right, m), node.lc)
            if (right > m) sum += sumRange(maxOf(m + 1, left), right, node.rc)
            return sum
        }
        return sumRange(left, right, 0)
    }
}