package cn_solution

import kotlin.math.sign

fun isWinner(player1: IntArray, player2: IntArray): Int {
    fun IntArray.value() = fold(intArrayOf(0, 0, 0)) { a, v ->
        a[0] += v * ((a[1] + a[2]).sign + 1)
        a[1] = a[2]
        a[2] = v / 10
        a
    }[0]

    val diff = player1.value() - player2.value()
    return if (diff < 0) 2 else diff.sign
}