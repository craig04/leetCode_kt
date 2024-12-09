package cn_solution

import kotlin.math.abs

fun escapeGhosts(ghosts: Array<IntArray>, target: IntArray): Boolean {
    val (x, y) = target
    return ghosts.minOf { (u, v) -> abs(u - x) + abs(v - y) } > abs(x) + abs(y)
}