package cn_solution

fun findSpecialInteger(arr: IntArray): Int {
    fun ceiling(key: Int): Int {
        var l = 0
        var r = arr.size
        while (l != r) {
            val m = (l + r) shr 1
            if (arr[m] < key)
                l = m + 1
            else
                r = m
        }
        return l
    }

    val k = arr.size / 4 + 1
    for (i in k - 1 until arr.size step k)
        if (ceiling(arr[i] + 1) - ceiling(arr[i]) >= k)
            return arr[i]
    return -1
}