package cn_solution

import kotlin.math.abs

fun minMovesToCaptureTheQueen(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int): Int {
    fun range(x: Int, y: Int) = minOf(x, y)..maxOf(x, y)
    return if (
        a == e && (c != a || d !in range(b, f)) ||
        b == f && (d != b || c !in range(a, e)) ||
        abs(c - e) == abs(d - f) && (a !in range(c, e) || (a - c) * (b - f) != (a - e) * (b - d))
    ) 1 else 2
}