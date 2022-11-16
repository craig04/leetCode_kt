package cn_solution

fun peakIndexInMountainArray(arr: IntArray): Int {
    var l = 1
    var r = arr.size - 2
    while (l != r) {
        val m = (l + r) shr 1
        if (arr[m] < arr[m + 1])
            l = m + 1
        else
            r = m
    }
    return r
}
