package solution_cn

fun flipgame(fronts: IntArray, backs: IntArray): Int {
    val bad = fronts.filterIndexedTo(HashSet()) { i, n -> n == backs[i] }
    var result = Int.MAX_VALUE
    fun test(n: Int) {
        if (n !in bad) result = result.coerceAtMost(n)
    }
    for (i in fronts.indices) {
        test(fronts[i])
        test(backs[i])
    }
    return if (result == Int.MAX_VALUE) 0 else result
}