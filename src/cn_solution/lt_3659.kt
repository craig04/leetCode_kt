package cn_solution

private fun partitionArray(nums: IntArray, k: Int): Boolean {
    val n = nums.size
    if (n % k != 0)
        return false
    val max = nums.size / k
    val map = HashMap<Int, Int>()
    return nums.all { (map.merge(it, 1, Int::plus) ?: 0) <= max }
}