package cn_solution

fun minIncrementForUnique(nums: IntArray): Int {
    nums.sort()
    var min = 0
    var ans = 0
    for (num in nums) {
        ans += maxOf(0, min - num)
        min = maxOf(min, num) + 1
    }
    return ans
}