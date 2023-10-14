package cn_solution

fun minIncrementOperations(nums: IntArray, k: Int): Long {
    var (a, b, c) = longArrayOf(0, 0, 0)
    for (n in nums) {
        val d = minOf(a, b, c) + maxOf(0, k - n)
        a = b
        b = c
        c = d
    }
    return minOf(a, b, c)
}