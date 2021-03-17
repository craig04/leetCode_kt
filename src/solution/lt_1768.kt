package solution

fun mergeAlternately(word1: String, word2: String): String {
    return buildString {
        val len = minOf(word1.length, word2.length)
        for (i in 0 until len) {
            append(word1[i], word2[i])
        }
        append(word1.substring(len, word1.length))
        append(word2.substring(len, word2.length))
    }
}