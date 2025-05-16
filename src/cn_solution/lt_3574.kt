package cn_solution

fun maxGCDScore(nums: IntArray, k: Int): Long {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    var ans = 0L
    for (j in nums.indices) {
        var gcd = 0
        var min = Int.MAX_VALUE
        var cnt = 1
        for (i in j downTo 0) {
            val low = nums[i].takeLowestOneBit()
            if (min > low) {
                min = low
                cnt = 1
            } else if (min == low)
                cnt++
            gcd = gcd(gcd, nums[i])
            var cur = gcd
            if (cnt <= k)
                cur *= 2
            ans = maxOf(ans, cur * (j - i + 1L))
        }
    }
    return ans
}