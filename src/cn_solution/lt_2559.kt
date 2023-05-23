package cn_solution

fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
    val count = IntArray(words.size + 1)
    val vowel = "aeiou"
    words.forEachIndexed { i, w ->
        count[i + 1] = count[i]
        if (w.first() in vowel && w.last() in vowel) {
            count[i + 1]++
        }
    }
    return IntArray(queries.size) { count[queries[it][1] + 1] - count[queries[it][0]] }
}