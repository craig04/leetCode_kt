package cn_solution

fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
    val map = IntArray(minOf(nums.size + 1, modulo))
    map[0] = 1
    var cnt = 0
    var ans = 0L
    for (i in nums.indices) {
        if (nums[i] % modulo == k)
            cnt = (cnt + 1) % modulo
        val idx = (cnt + modulo - k) % modulo
        if (idx in map.indices)
            ans += map[idx]
        map[cnt]++
    }
    return ans
}