package cn_solution

import kotlin.math.ceil
import kotlin.math.log

fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
    return ceil(log(buckets.toDouble(), minutesToTest / minutesToDie + 1.0) - 1e-5).toInt()
}