package solution_cn

fun longestNiceSubstring(s: String): String {
    val ca = s.toCharArray()
    var pos = -1
    var len = -1
    fun search(l: Int, r: Int) {
        var lower = 0
        var upper = 0
        for (i in l until r) {
            if (ca[i].isLowerCase()) {
                lower = lower.or(1.shl(ca[i] - 'a'))
            } else {
                upper = upper.or(1.shl(ca[i] - 'A'))
            }
        }
        if (lower == upper) {
            if (r - l > len) {
                len = r - l
                pos = l
            }
            return
        }
        val diff = lower.xor(upper)
        var start = l
        while (start < r) {
            var end = start
            while (end != r && 1.shl(ca[end].toLowerCase() - 'a').and(diff) == 0) {
                end++
            }
            if (start != end) {
                search(start, end)
            }
            start = end + 1
        }
    }
    search(0, ca.size)
    return if (pos == -1) "" else s.substring(pos, pos + len)
}