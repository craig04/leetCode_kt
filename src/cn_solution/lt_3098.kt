package cn_solution

fun sumOfPowers(nums: IntArray, k: Int): Int {
    nums.sort()
    val modulo = 1000000007L
    val n = nums.size
    val dp = Array(k + 1) { Array(n) { HashMap<Int, Long>() } }
    dp[1].forEach { it[Int.MAX_VALUE] = 1 }
    for (len in 2..k) {
        for (i in len - 1 until n) {
            for (j in 0 until i) {
                val cur = nums[i] - nums[j]
                for ((pre, cnt) in dp[len - 1][j]) {
                    dp[len][i].merge(minOf(cur, pre), cnt) { a, b -> (a + b) % modulo }
                }
            }
        }
    }
    var ans = 0L
    for (i in 0 until n)
        for ((diff, cnt) in dp[k][i])
            ans = (ans + diff * cnt) % modulo
    return ans.toInt()
}