package cn_solution

fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
    arr.sort()
    return arr.fold(0) { ans, a -> minOf(ans + 1, a) }
}