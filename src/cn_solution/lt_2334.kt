package cn_solution

fun validSubarraySize(nums: IntArray, threshold: Int): Int {
    val n = nums.size
    val a = Array(n) { intArrayOf(it, nums[it]) }
    a.sortByDescending { it[1] }
    val p = IntArray(n) { it }
    val sz = IntArray(n)
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    var i = 0
    for (len in 1..nums.size) {
        val t = threshold / len
        while (i < n && a[i][1] > t) {
            val x = a[i++][0]
            if (x != 0) {
                val y = find(x - 1)
                if (sz[y] != 0) {
                    p[y] = x
                    sz[x] += sz[y]
                }
            }
            if (x != n - 1) {
                val y = find(x + 1)
                if (sz[y] != 0) {
                    p[y] = x
                    sz[x] += sz[y]
                }
            }
            if (++sz[x] >= len)
                return len
        }
    }
    return -1
}