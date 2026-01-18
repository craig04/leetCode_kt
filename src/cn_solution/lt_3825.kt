package cn_solution

private fun longestSubsequence(nums: IntArray): Int {
    var bit = nums.max().takeHighestOneBit()
    val s = IntArray(nums.size + 1)
    s[0] = -1
    var ans = 0
    while (bit != 0) {
        var top = 1
        for (num in nums) {
            if (num and bit == 0)
                continue
            var pos = s.binarySearch(num, 0, top)
            if (pos < 0)
                pos = pos.inv()
            if (pos == top)
                top++
            s[pos] = num
        }
        ans = maxOf(ans, top - 1)
        bit = bit shr 1
    }
    return ans
}