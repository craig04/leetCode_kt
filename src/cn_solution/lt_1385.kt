package cn_solution

fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
    arr2.sort()
    return arr1.count {
        var l = 0
        var r = arr2.size
        while (l != r) {
            val m = (l + r) shr 1
            when {
                arr2[m] > it -> r = m
                arr2[m] < it -> l = m + 1
                else -> return@count false
            }
        }
        (r == arr2.size || arr2[r] - it > d) && (r == 0 || it - arr2[r - 1] > d)
    }
}
