package cn_solution

import kotlin.math.abs

fun furthestDistanceFromOrigin(moves: String): Int {
    var dir = 0
    var any = 0
    for (move in moves) {
        when (move) {
            'L' -> dir++
            'R' -> dir--
            '_' -> any++
        }
    }
    return abs(dir) + any
}