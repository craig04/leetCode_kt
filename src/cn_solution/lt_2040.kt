package cn_solution

fun kthSmallestProduct(nums1: IntArray, nums2: IntArray, k: Long): Long {
    val n = nums1.size
    val m = nums2.size
    fun IntArray.lowerBound(num: Int): Int {
        var l = 0
        var r = size
        while (l != r) {
            val m = (l + r) shr 1
            if (get(m) < num)
                l = m + 1
            else
                r = m
        }
        return l
    }

    val x = nums1.lowerBound(0)
    val y = nums2.lowerBound(0)
    val a = LongArray(n) { nums1[it] + 0L }
    val b = LongArray(m) { nums2[it] + 0L }
    fun check(num: Long): Boolean {
        var cnt = 0L
        var j = m - 1
        for (i in x until n) {
            while (j >= y && a[i] * b[j] > num)
                j--
            cnt += j - y + 1
        }
        j = 0
        for (i in x - 1 downTo 0) {
            while (j < y && a[i] * b[j] > num)
                j++
            cnt += y - j
        }
        j = y - 1
        for (i in n - 1 downTo x) {
            while (j >= 0 && a[i] * b[j] > num)
                j--
            cnt += j + 1
        }
        j = y
        for (i in 0 until x) {
            while (j < m && a[i] * b[j] > num)
                j++
            cnt += m - j
        }
        return cnt >= k
    }

    val corners = longArrayOf(a[0] * b[0], a[0] * b[m - 1], a[n - 1] * b[0], a[n - 1] * b[m - 1])
    var l = corners.min()
    var r = corners.max()
    while (l != r) {
        val mid = l + (r - l) / 2
        if (check(mid))
            r = mid
        else
            l = mid + 1
    }
    return l
}