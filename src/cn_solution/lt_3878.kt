package cn_solution

fun countGoodSubarrays(nums: IntArray): Long {
    val s = arrayListOf(intArrayOf(-1, -1))
    val n = nums.size
    val left = IntArray(n)
    for (i in nums.indices) {
        val x = nums[i]
        while (s.last()[0] or x == x)
            s.removeLast()
        left[i] = s.last()[1]
        s += intArrayOf(x, i)
    }
    var ans = 0L
    s.clear()
    s += intArrayOf(Int.MAX_VALUE, n)
    for (i in nums.indices.reversed()) {
        val x = nums[i]
        while (s.last()[0] or x == x && s.last()[0] != x)
            s.removeLast()
        ans += 1L * (i - left[i]) * (s.last()[1] - i)
        s += intArrayOf(x, i)
    }
    return ans
}