package solution_cn

fun lastStoneWeightII(stones: IntArray): Int {
    val sum = stones.sum()
    val dp = IntArray(sum / 2 + 1)
    dp[0] = 1
    stones.forEach {
        for (j in dp.lastIndex downTo it) {
            dp[j] += dp[j - it]
        }
    }
    return sum - dp.indexOfLast { it != 0 } * 2
}