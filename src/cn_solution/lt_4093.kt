package cn_solution

private fun maximizeSum(nums: IntArray, k: Int): Long {
    val q = java.util.PriorityQueue<Long>()
    var sum = 0L
    val digits = IntArray(10)
    for (i in nums.indices) {
        var x = nums[i]
        sum += x
        var len = 0
        while (x != 0) {
            digits[len++] = x % 10
            x /= 10
        }
        digits.sort(0, len)
        var add = 0L
        var pow = 1L
        x = nums[i]
        for (j in 0 until len) {
            add += pow * (digits[j] - x % 10)
            pow *= 10
            x /= 10
        }
        q += add
        if (q.size > k)
            q.poll()
    }
    return sum + q.sum()
}