package cn_solution

fun findLengthOfShortestSubarray(arr: IntArray): Int {
    val n = arr.size
    var l = 0
    while (l < n - 1 && arr[l] <= arr[l + 1])
        l++
    if (l == n - 1)
        return 0
    var r = n - 1
    while (arr[r - 1] > arr[r])
        r--
    var ans = r
    for (i in 0..l) {
        while (r != n && arr[i] > arr[r])
            r++
        ans = minOf(ans, r - i - 1)
    }
    return ans
}