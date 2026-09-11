package cn_solution

private fun minOperations(nums: IntArray, x: Int): Int {
    val t = nums.sum() - x
    if (t < 0)
        return -1
    var sum = 0
    var len = -1
    var i = 0
    for (j in nums.indices) {
        sum += nums[j]
        while (sum > t)
            sum -= nums[i++]
        if (sum == t)
            len = maxOf(len, j - i + 1)
    }
    return if (len == -1) -1 else nums.size - len
}