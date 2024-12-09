package cn_solution

fun uniqueMorseRepresentations(words: Array<String>): Int {
    val morse = arrayOf(
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
        ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
        "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    )
    return words.mapTo(HashSet()) { word -> word.asSequence().joinToString("") { morse[it - 'a'] } }.size
}