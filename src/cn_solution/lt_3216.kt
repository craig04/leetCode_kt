package cn_solution

import kotlin.math.abs

fun getSmallestString(s: String): String {
    val a = s.toCharArray()
    for (i in 0 until a.lastIndex) {
        if (abs(a[i + 1] - a[i]) % 2 == 0 && a[i] > a[i + 1]) {
            val c = a[i]
            a[i] = a[i + 1]
            a[i + 1] = c
            return String(a)
        }
    }
    return s
}