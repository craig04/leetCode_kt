package cn_solution

private fun isValid(word: String): Boolean {
    val vowels = "aeiou"
    var letter = 0
    return word.length >= 3 && word.all { c ->
        if (c.isLetter()) {
            letter = letter or if (c.lowercaseChar() in vowels) 1 else 2
            true
        } else
            c.isDigit()
    } && letter == 3
}