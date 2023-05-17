package cn_solution

fun findLengthOfShortestSubarray(arr: IntArray): Int {
    val n = arr.size
    var left = 0
    var right = n - 1
    while (left + 1 != n && arr[left] <= arr[left + 1])
        left++
    while (right != 0 && arr[right - 1] <= arr[right])
        right--
    var result = maxOf(left + 1, n - right)
    var q = right
    for (p in 0..left) {
        while (p == q || (q != n && arr[p] > arr[q]))
            q++
        result = maxOf(result, p + 1 + n - q)
    }
    return n - result
}
