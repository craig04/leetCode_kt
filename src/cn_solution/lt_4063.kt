package cn_solution

private fun longestSubarray(nums: IntArray, k: Int): Int {
    fun length(): Int {
        val map = hashMapOf(0 to -1)
        var sum = 0
        var ans = 0
        for (j in nums.indices) {
            sum = (sum + nums[j]) % k
            val i = map.putIfAbsent(sum, j)
            if (i != null)
                ans = maxOf(ans, j - i)
        }
        return ans
    }

    var ans = length()
    nums.forEachIndexed { i, x ->
        nums[i] = -x
        ans = maxOf(ans, length())
        nums[i] = x
    }
    return ans
}