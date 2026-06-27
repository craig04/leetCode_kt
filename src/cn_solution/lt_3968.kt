package cn_solution

import kotlin.math.abs

fun maxDistance(moves: String): Int {
    var x = 0
    var y = 0
    var any = 0
    for (move in moves) {
        when (move) {
            'L' -> x--
            'R' -> x++
            'D' -> y--
            'U' -> y++
            '_' -> any++
        }
    }
    return abs(x) + abs(y) + any
}