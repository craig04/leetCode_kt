package cn_solution

fun validMountainArray(arr: IntArray): Boolean {
    val n = arr.size
    var i = 1
    while (i != n && arr[i - 1] < arr[i])
        i++
    if (i == 1 || i >= n)
        return false
    while (i != n && arr[i - 1] > arr[i])
        i++
    return i == n
}
