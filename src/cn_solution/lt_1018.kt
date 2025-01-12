package cn_solution

fun prefixesDivBy5(nums: IntArray): List<Boolean> {
    var x = 0
    return nums.map {
        x = (x * 2 + it) % 10
        x == 0 || x == 5
    }
}