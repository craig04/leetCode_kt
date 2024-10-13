package cn_solution

fun maximumSumSubsequence(nums: IntArray, queries: Array<IntArray>): Int {
    val modulo = 1000000007
    val n = nums.size
    val nodes = Array(n shl 2) { IntArray(4) }

    fun update(idx: Int, l: Int, r: Int) {
        val a = nodes[idx]
        val b = nodes[l]
        val c = nodes[r]
        a[0] = maxOf(b[0] + c[2], b[1] + c[0]) % modulo
        a[1] = maxOf(b[0] + c[3], b[1] + c[1]) % modulo
        a[2] = maxOf(b[3] + c[0], b[2] + c[2]) % modulo
        a[3] = maxOf(b[3] + c[1], b[2] + c[3]) % modulo
    }

    fun create(idx: Int, left: Int, right: Int) {
        if (left == right) {
            nodes[idx][3] = maxOf(nums[left], 0)
            return
        }
        val mid = (left + right) shr 1
        val l = idx * 2 + 1
        val r = idx * 2 + 2
        create(l, left, mid)
        create(r, mid + 1, right)
        update(idx, l, r)
    }

    fun modify(idx: Int, left: Int, right: Int, pos: Int, x: Int) {
        if (left == right) {
            nodes[idx][3] = maxOf(x, 0)
            return
        }
        val mid = (left + right) shr 1
        val l = idx * 2 + 1
        val r = idx * 2 + 2
        if (pos <= mid)
            modify(l, left, mid, pos, x)
        else
            modify(r, mid + 1, right, pos, x)
        update(idx, l, r)
    }

    create(0, 0, n - 1)
    return queries.fold(0) { acc, (pos, x) ->
        modify(0, 0, n - 1, pos, x)
        (acc + nodes[0][3]) % modulo
    }
}