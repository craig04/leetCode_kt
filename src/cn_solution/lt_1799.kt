package cn_solution

fun maxScore(nums: IntArray): Int {
    val n = nums.size
    val dp = hashMapOf(0 to 0)
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val gcd = Array(n) { i -> IntArray(n) { j -> gcd(nums[i], nums[j]) } }
    fun dfs(round: Int, mask: Int): Int = dp.getOrPut(mask) {
        var result = 0
        for (i in 0 until n) {
            val a = 1 shl i
            if (a and mask == 0)
                continue
            for (j in i + 1 until n) {
                val b = 1 shl j
                if (b and mask == 0)
                    continue
                val next = mask and a.inv() and b.inv()
                result = maxOf(result, round * gcd[i][j] + dfs(round + 1, next))
            }
        }
        result
    }
    return dfs(1, 1.shl(n) - 1)
}