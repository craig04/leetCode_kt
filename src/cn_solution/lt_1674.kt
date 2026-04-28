package cn_solution

private fun minMoves(nums: IntArray, limit: Int): Int {
    val d = IntArray(2 * limit + 2)
    for (i in 0 until nums.size / 2) {
        val x = nums[i]
        val y = nums[nums.size - 1 - i]
        val a = minOf(x, y)
        val b = maxOf(x, y)
        d[2] += 2
        d[a + 1]--
        d[a + b]--
        d[a + b + 1]++
        d[b + limit + 1]++
    }
    var sum = 0
    var ans = Int.MAX_VALUE
    for (i in 2..2 * limit) {
        sum += d[i]
        ans = minOf(sum, ans)
    }
    return ans
}