package solution

import kotlin.math.log
import kotlin.math.round

fun findNumbers(nums: IntArray): Int {
    return nums.count { (round(log(it.toDouble(), 10.0) * 1e8) / 1e8).toInt() and 1 == 1 }
}