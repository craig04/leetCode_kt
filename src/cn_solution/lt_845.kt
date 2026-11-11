package cn_solution

fun longestMountain(arr: IntArray): Int {
    var ans = 0
    var i = 0
    val n = arr.size
    while (i < n) {
        var j = i
        while (j + 1 < n && arr[j] < arr[j + 1])
            j++
        if (i == j) {
            i = j + 1
            continue
        }
        var k = j
        while (k + 1 < n && arr[k] > arr[k + 1])
            k++
        if (j != k)
            ans = maxOf(ans, k - i + 1)
        i = k
    }
    return ans
}