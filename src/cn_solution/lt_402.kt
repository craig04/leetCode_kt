package cn_solution

fun removeKdigits(num: String, k: Int): String {
    if (num.length == k)
        return "0"
    val sb = StringBuilder()
    var t = k
    for (c in num) {
        while (t > 0 && sb.isNotEmpty() && c < sb.last()) {
            t--
            sb.deleteAt(sb.lastIndex)
        }
        sb.append(c)
    }
    sb.setLength(minOf(num.length - k, sb.length))
    val pos = sb.indexOfFirst { it != '0' }
    return if (pos == -1) "0" else sb.substring(pos)
}