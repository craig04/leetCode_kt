package cn_solution

fun maxSum(nums: IntArray): Int {
    val max = IntArray(10)
    var result = -1
    for (i in nums.indices) {
        var digit = 0
        var temp = nums[i]
        while (temp != 0) {
            digit = maxOf(digit, temp % 10)
            temp /= 10
        }
        if (max[digit] != 0)
            result = maxOf(result, max[digit] + nums[i])
        max[digit] = maxOf(max[digit], nums[i])
    }
    return result
}