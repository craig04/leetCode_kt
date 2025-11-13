package cn_solution

fun maximizeExpressionOfThree(nums: IntArray): Int {
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    for (num in nums) {
        if (num > max1) {
            max2 = max1
            max1 = num
        } else if (num > max2)
            max2 = num
        min = minOf(min, num)
    }
    return max1 + max2 - min
}