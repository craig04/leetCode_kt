package cn_solution

import java.math.BigInteger.ONE

private fun maxTotalReward(rewardValues: IntArray): Int {
    val values = rewardValues.toHashSet().toIntArray()
    values.sort()
    return values.fold(ONE) { dp, value ->
        ONE.shl(value).subtract(ONE).and(dp).shl(value).or(dp)
    }.bitLength() - 1
}