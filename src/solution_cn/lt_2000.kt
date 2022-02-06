package solution_cn

fun reversePrefix(word: String, ch: Char): String {
    val index = word.indexOf(ch) + 1
    return if (index == 0) word else word.substring(0, index).reversed() + word.substring(index)
}