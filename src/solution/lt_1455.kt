package solution

fun isPrefixOfWord(sentence: String, searchWord: String): Int {
    val source = " $sentence"
    val pattern = " $searchWord"
    return source.indexOf(pattern).let { idx ->
        if (idx == -1) -1 else (0..idx).count { source[it] == ' ' }
    }
}