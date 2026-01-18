package cn_solution

import kotlin.math.abs

fun bestTower(towers: Array<IntArray>, center: IntArray, radius: Int): IntArray {
    var (u, v, w) = intArrayOf(-1, -1, -1)
    val (cx, cy) = center
    for (i in towers.indices) {
        val (x, y, z) = towers[i]
        if (abs(x - cx) + abs(y - cy) <= radius &&
            (z > w || (z == w && (x < u || (x == u && y < v))))
        ) {
            u = x
            v = y
            w = z
        }
    }
    return intArrayOf(u, v)
}