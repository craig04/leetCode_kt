package cn_solution

fun makeFancyString(s: String): String {
    val sb = StringBuilder("  ")
    return s.filterTo(sb) {
        it != sb.last() || it != sb[sb.length - 2]
    }.substring(2)
}