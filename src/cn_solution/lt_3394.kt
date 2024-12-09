package cn_solution

fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
    fun check(a: Int, b: Int): Boolean {
        rectangles.sortBy { it[a] }
        var cut = -1
        var pre = -1
        for (r in rectangles) {
            if (r[a] >= pre && ++cut == 2)
                return true
            pre = maxOf(pre, r[b])
        }
        return false
    }
    return check(0, 2) || check(1, 3)
}