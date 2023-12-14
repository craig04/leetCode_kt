package cn_solution

fun minLength(s: String): Int {
    val sb = StringBuilder()
    for (c in s) {
        if ((c == 'B' && sb.lastOrNull() == 'A') || (c == 'D' && sb.lastOrNull() == 'C'))
            sb.setLength(sb.length - 1)
        else
            sb.append(c)
    }
    return sb.length
}