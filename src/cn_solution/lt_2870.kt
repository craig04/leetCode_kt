package cn_solution

private fun minOperations(nums: IntArray): Int {
    val map = nums.asSequence().groupingBy { it }.eachCount()
    var ans = 0
    for (cnt in map.values) {
        if (cnt == 1)
            return -1
        ans += (cnt + 2) / 3
    }
    return ans
}