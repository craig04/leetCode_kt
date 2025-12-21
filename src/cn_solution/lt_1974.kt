package cn_solution

import kotlin.math.abs

fun minTimeToType(word: String): Int {
    var pre = 'a'
    return word.sumOf { cur ->
        val dis = abs(pre - cur)
        pre = cur
        minOf(dis, 26 - dis) + 1
    }
}