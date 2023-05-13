package cn_solution

fun closestCost(baseCosts: IntArray, toppingCosts: IntArray, target: Int): Int {
    val minBase = baseCosts.min() ?: return 0
    if (minBase >= target) {
        return minBase
    }
    val upper = target * 2 - minBase
    val dp = BooleanArray(upper + 1)
    for (base in baseCosts)
        if (base <= upper)
            dp[base] = true
    for (i in 0 until toppingCosts.size * 2) {
        val topping = toppingCosts[i / 2]
        for (j in upper downTo minBase + topping)
            dp[j] = dp[j] or dp[j - topping]
    }
    for (i in 0 until upper - target) {
        if (dp[target - i]) return target - i
        if (dp[target + i]) return target + i
    }
    return minBase
}