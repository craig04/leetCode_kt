package cn_solution

fun processStr(s: String, k: Long): Char {
    var len = s.fold(0L) { res, c ->
        when (c) {
            '*' -> maxOf(res - 1, 0)
            '#' -> res shl 1
            '%' -> res
            else -> res + 1
        }
    }
    if (k >= len)
        return '.'
    var t = k
    for (i in s.indices.reversed()) {
        when (s[i]) {
            '*' -> len++
            '#' -> {
                len /= 2
                t %= len
            }
            '%' -> t = len - 1 - t
            else -> if (t == len-- - 1) return s[i]
        }
    }
    return '.'
}