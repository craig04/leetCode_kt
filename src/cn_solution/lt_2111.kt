package cn_solution

fun kIncreasing(arr: IntArray, k: Int): Int {
    val n = arr.size
    if (k >= n)
        return 0
    val stack = IntArray(n / k + 2)
    stack[0] = Int.MIN_VALUE
    return (0 until k).sumOf {
        var len = 0
        var top = 1
        for (j in it until n step k) {
            len++
            var l = 0
            var r = top
            while (l != r) {
                val mid = (l + r) shr 1
                if (arr[j] >= stack[mid])
                    l = mid + 1
                else
                    r = mid
            }
            if (r == top)
                top++
            stack[r] = arr[j]
        }
        len - top + 1
    }
}