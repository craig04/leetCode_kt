package cn_solution

fun smallestUniqueSubarray(nums: IntArray): Int {
    fun check(len: Int): Boolean {
        val modulo = 1000000007
        val map = HashMap<Long, Int>()
        var pow = 1L
        var sum = 0L
        for (i in nums.indices) {
            sum = (sum * 79 + nums[i]) % modulo
            if (i < len - 1)
                pow = pow * 79 % modulo
            else {
                map.merge(sum, 1, Int::plus)
                sum = (sum - pow * nums[i - len + 1] % modulo + modulo) % modulo
            }
        }
        return map.values.any { it == 1 }
    }

    var l = 1
    var r = nums.size
    while (l != r) {
        val m = (l + r) / 2
        if (check(m))
            r = m
        else
            l = m + 1
    }
    return l
}