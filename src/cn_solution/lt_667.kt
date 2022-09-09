package cn_solution

fun constructArray(n: Int, k: Int): IntArray {
    val pivot = n - k
    val a = IntArray(n)
    for (i in 1 until pivot)
        a[i - 1] = i
    var low = pivot
    var high = n
    var i = pivot - 1
    while (low < high) {
        a[i++] = low++
        a[i++] = high--
    }
    if (low == high)
        a[i] = low
    return a
}