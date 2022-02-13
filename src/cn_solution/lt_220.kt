package cn_solution

fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val n = nums[i]
        val key = getKey(n, t + 1)
        if (map.put(key, n) != null
                || map[key - 1]?.let { near(n, it, t) } == true
                || map[key + 1]?.let { near(it, n, t) } == true) {
            return true
        }
        if (i >= k) map.remove(getKey(nums[i - k], t + 1))
    }
    return false
}

private fun near(p: Int, q: Int, diff: Int): Boolean {
    return if (p >= 0) p - diff <= q else q + diff >= p
}

private fun getKey(n: Int, t: Int): Int {
    return if (n >= 0) n / t else (n + 1) / t - 1
}