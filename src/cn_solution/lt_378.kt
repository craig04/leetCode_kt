package cn_solution

fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    var low = -1000000000
    var high = 1000000000
    while (low != high) {
        var cnt = 0
        val mid = (low + high + 1) shr 1
        for (line in matrix) {
            var l = -1
            var r = line.lastIndex
            while (l != r) {
                val m = (l + r + 1) shr 1
                if (line[m] >= mid)
                    r = m - 1
                else
                    l = m
            }
            cnt += r + 1
        }
        if (cnt >= k)
            high = mid - 1
        else
            low = mid
    }
    return low
}