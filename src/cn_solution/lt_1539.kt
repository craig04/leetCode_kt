package cn_solution

fun findKthPositive(arr: IntArray, k: Int): Int {
    var l = 0
    var r = arr.size
    while (l < r) {
        val m = (l + r) shr 1
        val diff = arr[m] - m - 1
        when {
            diff < k -> l = m + 1
            else -> r = m
        }
    }
    return k + r
}
