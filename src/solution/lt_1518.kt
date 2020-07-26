package solution

import kotlin.math.ceil

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    val ans = numBottles * numExchange / (numExchange - 1.0)
    return ceil(ans).toInt() - 1
}