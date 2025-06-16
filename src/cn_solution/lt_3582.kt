package cn_solution

fun generateTag(caption: String): String {
    val sb = StringBuilder("#")
    for (i in caption.indices) {
        if (caption[i] == ' ')
            continue
        else if (i != 0 && caption[i - 1] == ' ')
            sb.append(caption[i].uppercaseChar())
        else
            sb.append(caption[i].lowercaseChar())
    }
    if (sb.length >= 2)
        sb[1] = sb[1].lowercaseChar()
    sb.setLength(minOf(100, sb.length))
    return sb.toString()
}