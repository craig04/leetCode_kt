package cn_solution

fun repeatedStringMatch(a: String, b: String): Int {
    val sb = StringBuilder()
    val cnt = (b.length + a.length - 1) / a.length
    repeat(cnt) { sb.append(a) }
    return when {
        sb.indexOf(b) != -1 -> cnt
        sb.append(a).indexOf(b) != -1 -> cnt + 1
        else -> -1
    }
}