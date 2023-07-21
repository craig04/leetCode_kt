package cn_solution

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    fun StringBuilder.append(n: Int, c: Char) = repeat(n) { append(c) }
    val result = ArrayList<String>()
    var i = 0
    while (i < words.size) {
        var letter = 0
        var j = i
        while (j < words.size) {
            val next = letter + words[j].length
            if (next + j - i > maxWidth)
                break
            j++
            letter = next
        }
        val sb = StringBuilder()
        if (j == words.size) {
            for (t in i until j)
                sb.append(words[t]).append(' ')
            sb.setLength(sb.length - 1)
            sb.append(maxWidth - sb.length, ' ')
        } else {
            val cnt = j - i
            val space = maxWidth - letter
            val segment = maxOf(1, cnt - 1)
            for (t in 0 until cnt) {
                sb.append(words[i + t])
                if (t == 0 || t != j - i - 1) {
                    sb.append(space / segment, ' ')
                    if (t < space % segment)
                        sb.append(' ')
                }
            }
        }
        result.add(sb.toString())
        i = j
    }
    return result
}