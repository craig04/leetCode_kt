package cn_solution

fun maxValue(nums: IntArray): IntArray {
    val s = arrayListOf(intArrayOf(0, 0))
    for (i in nums.indices) {
        val max = maxOf(nums[i], s.last()[0])
        while (nums[i] < s.last()[0])
            s.removeLast()
        s.add(intArrayOf(max, i + 1))
    }
    val ans = IntArray(nums.size)
    for (i in 1 until s.size)
        ans.fill(s[i][0], s[i - 1][1], s[i][1])
    return ans
}