package cn_solution

fun addSpaces(s: String, spaces: IntArray): String {
    val sb = StringBuilder()
    var pre = 0
    for (space in spaces) {
        sb.append(s, pre, space).append(' ')
        pre = space
    }
    return sb.append(s, spaces.last(), s.length).toString()
}