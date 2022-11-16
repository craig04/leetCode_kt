package cn_solution

fun maximumRemovals(s: String, p: String, removable: IntArray): Int {
    fun isSubsequence(dest: Int): Boolean {
        val r = BooleanArray(s.length)
        (0..dest).forEach { r[removable[it]] = true }
        var j = 0
        return s.indices.any { !r[it] && s[it] == p[j] && ++j == p.length }
    }

    var l = -1
    var r = removable.lastIndex
    while (l != r) {
        val mid = (l + r + 1) shr 1
        when (isSubsequence(mid)) {
            true -> l = mid
            else -> r = mid - 1
        }
    }
    return l + 1
}
