package cn_solution

fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
    val n = nums1.size
    val map = IntArray(n)
    for (i in nums1.indices)
        map[nums1[i]] = i
    for (i in nums2.indices)
        nums2[i] = map[nums2[i]]
    val a = IntArray(n + 1)
    fun add(x: Int) {
        var y = x
        while (y <= n) {
            a[y]++
            y += y and -y
        }
    }

    fun query(x: Int): Int {
        var ans = 0
        var y = x
        while (y > 0) {
            ans += a[y]
            y = y and (y - 1)
        }
        return ans
    }

    var ans = 0L
    for (i in nums2.indices) {
        val x = nums2[i] + 1
        val low = query(x)
        val high = n - i - (x - low)
        ans += low * 1L * high
        add(x)
    }
    return ans
}