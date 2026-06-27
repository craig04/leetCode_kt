package cn_solution

import kotlin.math.abs

fun canReach(start: IntArray, target: IntArray): Boolean {
    return abs(start[0] + start[1] - target[0] - target[1]) % 2 == 0
}