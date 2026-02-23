package cn_solution

fun makeGood(s: String): String {
    val sb = StringBuilder()
    for (c in s) {
        val x = sb.lastOrNull()
        if (x == null || c.lowercaseChar() != x.lowercaseChar() && c == x)
            sb.append(c)
        else
            sb.deleteAt(sb.lastIndex)
    }
    return sb.toString()
}