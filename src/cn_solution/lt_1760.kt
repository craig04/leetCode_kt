package cn_solution

fun minimumSize(nums: IntArray, maxOperations: Int): Int {
    var l = 1
    var r = nums.max()
    while (l != r) {
        val m = (l + r) shr 1
        if (nums.sumOf { (it + m - 1) / m - 1 } <= maxOperations)
            r = m
        else
            l = m + 1
    }
    return l
}