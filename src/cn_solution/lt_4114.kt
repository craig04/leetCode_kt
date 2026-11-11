package cn_solution

private fun countConsistent(nums: IntArray): Int {
    val s = arrayListOf(-1)
    val n = nums.size
    val left = IntArray(n)
    for (i in nums.indices) {
        val x = nums[i]
        while (s.size > 1 && nums[s.last()] and x == x)
            s.removeLast()
        left[i] = s.last()
        s += i
    }
    s.clear()
    s += n
    var ans = 0
    for (i in nums.indices.reversed()) {
        val x = nums[i]
        while (s.size > 1) {
            val y = nums[s.last()]
            if (y == x || y and x != x)
                break
            s.removeLast()
        }
        ans += (i - left[i]) * (s.last() - i)
        s += i
    }
    return ans
}