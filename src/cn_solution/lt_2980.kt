package cn_solution

fun hasTrailingZeros(nums: IntArray): Boolean {
    var s = 0
    return nums.any {
        s += it and 1 xor 1
        s >= 2
    }
}