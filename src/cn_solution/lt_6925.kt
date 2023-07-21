package cn_solution

fun finalString(s: String): String {
    val sb = StringBuilder()
    for (c in s) {
        if (c == 'i') {
            sb.reverse()
        } else {
            sb.append(c)
        }
    }
    return sb.toString()
}