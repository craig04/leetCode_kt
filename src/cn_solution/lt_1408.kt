package cn_solution

fun stringMatching(words: Array<String>): List<String> {
    return words.filter { str ->
        words.any { it.length != str.length && it.indexOf(str) != -1 }
    }
}
