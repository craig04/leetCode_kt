package cn_solution

private fun maxTotalValue(nums: IntArray, k: Int): Long {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (num in nums) {
        min = minOf(min, num)
        max = maxOf(max, num)
    }
    return (max - min + 0L) * k
}