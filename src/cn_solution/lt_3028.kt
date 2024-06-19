package cn_solution

fun returnToBoundaryCount(nums: IntArray): Int {
    var pos = 0
    return nums.count {
        pos += it
        pos == 0
    }
}