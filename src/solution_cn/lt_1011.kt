package solution_cn

fun shipWithinDays(weights: IntArray, D: Int): Int {

    fun canShip(W: Int): Boolean {
        var sum = 0
        var days = 0
        for (w in weights) {
            if (w > W)
                return false
            if (sum + w > W) {
                sum = w
                if (++days > D)
                    return false
            } else {
                sum += w
            }
        }
        return days < D
    }

    var min = 1
    var max = weights.sum()
    while (min != max) {
        val mid = (min + max) shr 1
        when {
            canShip(mid) -> max = mid
            else -> min = mid + 1
        }
    }
    return min
}