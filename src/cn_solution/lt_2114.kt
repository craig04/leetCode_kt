package cn_solution

fun mostWordsFound(sentences: Array<String>): Int {
    return sentences.maxOf { s -> s.count { it == ' ' } + 1 }
}