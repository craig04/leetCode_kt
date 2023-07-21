package cn_offer

fun replaceSpace(s: String): String {
    return s.fold(StringBuilder()) { sb, c ->
        if (c == ' ') sb.append("%20") else sb.append(c)
    }.toString()
}