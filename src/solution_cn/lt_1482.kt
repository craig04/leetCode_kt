package solution_cn

fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
    if (m * k > bloomDay.size) {
        return -1
    }
    fun canMake(days: Int): Boolean {
        var flowers = 0
        var bouquets = 0
        for (n in bloomDay) {
            if (n > days) {
                flowers = 0
            } else if (++flowers == k) {
                flowers = 0
                if (++bouquets >= m) {
                    return true
                }
            }
        }
        return false
    }

    var left = Int.MAX_VALUE
    var right = Int.MIN_VALUE
    for (n in bloomDay) {
        left = left.coerceAtMost(n)
        right = right.coerceAtLeast(n)
    }
    while (left != right) {
        val mid = (left + right) shr 1
        if (canMake(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}