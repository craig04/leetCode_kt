package solution_cn

fun findWords(words: Array<String>): Array<String> {
    val lines = intArrayOf(1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2)
    fun Char.line() = lines[toLowerCase() - 'a']
    return words.filter { word ->
        val idx = word[0].line()
        word.all { it.line() == idx }
    }.toTypedArray()
}