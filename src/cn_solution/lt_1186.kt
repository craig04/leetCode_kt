package cn_solution

fun maximumSum(arr: IntArray): Int {
    var a = arr[0]
    var b = 0
    return (1 until arr.size).fold(arr[0]) { acc, i ->
        val n = arr[i]
        b = maxOf(b + n, a)
        a = maxOf(a, 0) + n
        maxOf(acc, a, b)
    }
}