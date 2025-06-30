package cn_solution

fun processStr(s: String): String {
    return s.fold(StringBuilder()) { sb, c ->
        when (c) {
            '*' -> if (sb.isEmpty()) sb else sb.deleteCharAt(sb.lastIndex)
            '#' -> sb.append(sb)
            '%' -> sb.reverse()
            else -> sb.append(c)
        }
    }.toString()
}