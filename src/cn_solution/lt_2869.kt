package cn_solution

fun minOperations(nums: List<Int>, k: Int): Int {
    val t = 2L.shl(k) - 2
    var s = 0L
    val n = nums.size
    for (i in 1..n) {
        s = 1L.shl(nums[i]).or(s)
        if (s and t == t)
            return i
    }
    return 0
}