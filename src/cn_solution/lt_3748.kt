package cn_solution

fun countStableSubarrays(nums: IntArray, queries: Array<IntArray>): LongArray {
    fun cnt(len: Int) = (len + 1L) * len / 2
    val n = nums.size
    val left = ArrayList<Int>()
    val s = arrayListOf(0L)
    var i = 0
    while (i != n) {
        var j = i + 1
        while (j != n && nums[j - 1] <= nums[j])
            j++
        left += i
        s += s.last() + cnt(j - i)
        i = j
    }
    fun search(x: Int): Int {
        var l = 0
        var r = left.lastIndex
        while (l < r) {
            val m = (l + r + 1) shr 1
            if (left[m] <= x)
                l = m
            else
                r = m - 1
        }
        return l
    }
    return LongArray(queries.size) { i ->
        val (l, r) = queries[i]
        val x = search(l)
        val y = search(r)
        if (x == y)
            return@LongArray cnt(r - l + 1)
        (s[y] - s[x + 1]) + cnt(r - left[y] + 1) + cnt(left[x + 1] - l)
    }
}