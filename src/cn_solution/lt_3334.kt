package cn_solution

private fun maxScore(nums: IntArray): Long {
    fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
    fun lcm(a: Long, b: Long): Long = a * b / gcd(a, b)
    return (0..nums.size).maxOf { i ->
        var gcd = 0L
        var lcm = 1L
        for (j in nums.indices) {
            if (j == i)
                continue
            val long = nums[j].toLong()
            gcd = gcd(gcd, long)
            lcm = lcm(lcm, long)
        }
        gcd * lcm
    }
}