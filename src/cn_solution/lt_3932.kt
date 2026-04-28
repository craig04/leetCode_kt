package cn_solution

import kotlin.math.pow

fun countKthRoots(l: Int, r: Int, k: Int): Int {
    if (k == 1)
        return r - l + 1
    var ans = 0
    var x = 1.0
    do {
        val y = x.pow(k)
        if (y > r)
            break
        if (y >= l)
            ans++
        x++
    } while (true)
    return ans
}