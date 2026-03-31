package cn_solution

fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean {
    fun String.sum() = fold(0) { ans, c -> ans * 10 + (c - 'a') }
    return firstWord.sum() + secondWord.sum() == targetWord.sum()
}