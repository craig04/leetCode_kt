package cn_solution

fun diagonalPrime(nums: Array<IntArray>): Int {
    var ans = 0
    fun update(x: Int) {
        if (x == 1 || x <= ans)
            return
        var i = 2
        while (i * i <= x)
            if (x % i++ == 0)
                return
        ans = maxOf(ans, x)
    }

    val n = nums.size
    for (i in nums.indices) {
        update(nums[i][i])
        update(nums[i][n - i - 1])
    }
    return ans
}