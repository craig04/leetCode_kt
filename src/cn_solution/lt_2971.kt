package cn_solution

private fun largestPerimeter(nums: IntArray): Long {
    nums.sort()
    var sum = 0L
    return nums.fold(-1L) { ans, num ->
        sum += num
        if (sum > num * 2) sum else ans
    }
}