package cn_lcr

fun countSubstrings(s: String): Int {
    fun count(i: Int, j: Int): Int {
        var x = i
        var y = j
        while (x >= 0 && y < s.length && s[x] == s[y]) {
            x--
            y++
        }
        return (y - x) shr 1
    }
    return s.indices.sumOf { count(it, it) + count(it, it + 1) }
}