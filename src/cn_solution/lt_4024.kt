package cn_solution

import kotlin.math.abs

fun nearestDrone(drones: Array<IntArray>, target: IntArray): Int {
    var ans = -1
    var min = Int.MAX_VALUE
    val (x, y) = target
    for (i in drones.indices) {
        val (u, v, w) = drones[i]
        val dis = abs(x - u) + abs(y - v)
        if (dis <= w && dis < min) {
            ans = i
            min = dis
        }
    }
    return ans
}