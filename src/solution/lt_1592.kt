package solution

fun reorderSpaces(text: String): String {
    var spaces = 0
    val words = arrayListOf<String>()
    var start = 0
    val len = text.length
    while (start != len) {
        if (text[start] == ' ') {
            start++
            spaces++
            continue
        }
        var end = start
        @Suppress("ControlFlowWithEmptyBody")
        while (++end != len && text[end] != ' ');
        words.add(text.substring(start, end))
        start = end
    }
    val num = if (words.size == 1) spaces else spaces / (words.size - 1)
    val rem = spaces - num * (words.size - 1)
    return buildString {
        words.forEachIndexed { index, s ->
            append(s).append(' ', if (index == words.size - 1) rem else num)
        }
    }
}

private fun StringBuilder.append(c: Char, count: Int): StringBuilder {
    repeat(count) { append(c) }
    return this
}