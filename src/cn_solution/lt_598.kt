package cn_solution

fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
    var a = m
    var b = n
    for ((x, y) in ops) {
        a = a.coerceAtMost(x)
        b = b.coerceAtMost(y)
    }
    return a * b
}