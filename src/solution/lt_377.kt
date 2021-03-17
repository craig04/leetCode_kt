package solution

import java.util.*

fun combinationSum4(nums: IntArray, target: Int): Int {
    Arrays.sort(nums)
    val dp = IntArray(target + 1) { 0 }
    dp[0] = 1
    for (i in 0 until target) {
        for (num in nums) {
            if (i + num > target) {
                break
            }
            dp[i + num] += dp[i]
        }
    }
    return dp[target]
}