package cn_solution

fun removeOccurrences(s: String, part: String): String {
    val sb = StringBuilder()
    for (c in s) {
        sb.append(c)
        if (sb.endsWith(part))
            sb.delete(sb.length - part.length, sb.length)
    }
    return sb.toString()
}