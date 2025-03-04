package cn_solution

import kotlin.math.pow

fun divisorSubstrings(num: Int, k: Int): Int {
    val pow = 10.0.pow(k).toInt()
    var x = num
    var ans = 0
    while (x >= pow / 10) {
        val y = x % pow
        if (y != 0 && num % y == 0)
            ans++
        x /= 10
    }
    return ans
}