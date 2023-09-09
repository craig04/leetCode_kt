package cn_solution

fun minimumLengthEncoding(words: Array<String>): Int {
    var last = ""
    return Array(words.size) { words[it].reversed() }
        .apply { sort() }
        .sumOf {
            (if (it.startsWith(last)) 0 else last.length + 1).apply { last = it }
        } + last.length + 1
}