package cn_solution

fun climbStairs(n: Int, costs: IntArray): Int {
    var x = 0
    var y = 0
    var z = 0
    for (i in 0 until n) {
        val w = costs[i] + minOf(9 + x, 4 + y, 1 + z)
        x = y
        y = z
        z = w
    }
    return z
}