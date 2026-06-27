package cn_solution

fun maxPairStrength(nums: IntArray): Long {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    var ans = 0L
    for (i in nums.indices)
        for (j in i + 1 until nums.size) {
            val gcd = gcd(nums[i], nums[j])
            ans = maxOf(ans, 1L * nums[i] * nums[j] / gcd / gcd)
        }
    return ans
}