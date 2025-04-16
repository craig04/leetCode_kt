package cn_solution

fun maximumPossibleSize(nums: IntArray): Int {
    var ans = 0
    var max = 0
    for (num in nums) {
        if (num >= max) {
            ans++
            max = num
        }
    }
    return ans
}