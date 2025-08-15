package cn_solution

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val a = nums.copyOf()
    a.sort()
    return IntArray(nums.size) { i ->
        var l = 0
        var r = nums.size
        while (l < r) {
            val m = (l + r) shr 1
            if (a[m] < nums[i])
                l = m + 1
            else
                r = m
        }
        r
    }
}