package cn_solution

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) {
        return s
    }
    val sb = StringBuilder()
    val gap = 2 * numRows - 2
    fun Int.func() = if (this == 0) gap else this
    for (r in 0 until numRows) {
        var i = r
        var t = (gap - 2 * r).func()
        while (i < s.length) {
            sb.append(s[i])
            i += t
            t = (gap - t).func()
        }
    }
    return sb.toString()
}