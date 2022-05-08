package cn_solution

fun numberOfLines(widths: IntArray, s: String): IntArray {
    var lines = 1
    var width = 0
    for (c in s) {
        val w = widths[c - 'a']
        width += w
        if (width > 100) {
            lines++
            width = w
        }
    }
    return intArrayOf(lines, width)
}