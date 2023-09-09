package cn_solution

fun minCapability(nums: IntArray, k: Int): Int {
    var l = Int.MAX_VALUE
    var r = Int.MIN_VALUE
    nums.forEach {
        l = minOf(l, it)
        r = maxOf(r, it)
    }
    while (l != r) {
        val m = (l + r) shr 1
        var i = 0
        var left = k
        while (left > 0 && (nums.size - i + 1) / 2 >= left) {
            if (nums[i++] <= m) {
                left--
                i++
            }
        }
        if (left == 0)
            r = m
        else
            l = m + 1
    }
    return r
}