package cn_solution

fun arrangeWords(text: String): String {
    val words = text.split(' ').toTypedArray()
    words.sortBy { it.length }
    val sb = words.joinTo(StringBuilder(), " ") { it.lowercase() }
    sb[0] = sb[0].uppercaseChar()
    return sb.toString()
}