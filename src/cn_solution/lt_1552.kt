package cn_solution

fun maxDistance(position: IntArray, m: Int): Int {
    fun reach(dist: Int): Boolean {
        var count = 0
        var last = Int.MIN_VALUE
        for (pos in position) {
            if (pos >= last + dist) {
                if (++count >= m)
                    return true
                last = pos
            }
        }
        return false
    }
    position.sort()
    var left = 1
    var right = position.last() - position.first()
    while (left != right) {
        val mid = (left + right + 1) shr 1
        when (reach(mid)) {
            true -> left = mid
            else -> right = mid - 1
        }
    }
    return left
}
