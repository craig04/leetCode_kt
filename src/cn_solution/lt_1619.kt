package cn_solution

fun trimMean(arr: IntArray): Double {
    arr.sort()
    val n = arr.size
    val m = n / 20
    return (m until n - m).sumBy { arr[it] } * (n - m * 2.0)
}
