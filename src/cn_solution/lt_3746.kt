package cn_solution

import kotlin.math.abs

fun minLengthAfterRemovals(s: String): Int {
    return abs(s.count { it == 'a' } * 2 - s.length)
}