package cn_solution

fun getSmallestString(s: String, k: Int): String {
    val sb = StringBuilder()
    var r = k
    var i = 0
    while (r != 0 && i != s.length) {
        val c = s[i++]
        val dist = minOf(c - 'a', 'z' + 1 - c)
        if (dist <= r) {
            sb.append('a')
            r -= dist
        } else {
            sb.append(c - r)
            r = 0
        }
    }
    sb.append(s, i, s.length)
    return sb.toString()
}