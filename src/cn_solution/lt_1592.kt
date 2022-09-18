package cn_solution

fun reorderSpaces(text: String): String {
    val words = ArrayList<String>()
    var last = -1
    var spaces = 0
    for (i in text.indices) {
        if (text[i] == ' ') {
            spaces++
            if (i != last + 1)
                words.add(text.substring(last + 1, i))
            last = i
        }
    }
    if (last != text.lastIndex)
        words.add(text.substring(last + 1))
    fun StringBuilder.space(n: Int) = repeat(n) { append(' ') }
    return buildString {
        val t = words.size - 1
        val count = if (t == 0) 0 else spaces / t
        for (i in 0 until t) {
            append(words[i])
            space(count)
        }
        append(words.last())
        space(spaces - t * count)
    }
}
