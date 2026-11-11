package cn_solution

fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
    var (a, b, c, d) = IntArray(4) { Int.MIN_VALUE }
    return arr1.indices.maxOf { i ->
        val x = arr1[i] + arr2[i] - i
        val y = arr1[i] - arr2[i] - i
        val z = -arr1[i] + arr2[i] - i
        val w = -arr1[i] - arr2[i] - i
        a = maxOf(a, x)
        b = maxOf(b, y)
        c = maxOf(c, z)
        d = maxOf(d, w)
        maxOf(a - x, b - y, c - z, d - w)
    }
}