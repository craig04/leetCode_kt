package cn_solution

private fun maxSum(nums: IntArray): Int {
    val set = HashSet<Int>()
    var sum = 0
    var neg = Int.MIN_VALUE
    for (num in nums) {
        if (num < 0)
            neg = maxOf(neg, num)
        else if (set.add(num))
            sum += num
    }
    return if (set.isEmpty()) neg else sum
}