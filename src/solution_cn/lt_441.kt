package solution_cn

import kotlin.math.floor
import kotlin.math.sqrt

fun arrangeCoins(n: Int): Int {
    return floor((sqrt(8.0 * n + 1) - 1) / 2).toInt()
}