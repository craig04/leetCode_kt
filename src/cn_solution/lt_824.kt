package cn_solution

fun toGoatLatin(sentence: String): String {
    return buildString {
        var i = 0
        var index = 1
        val vowels = "aeiouAEIOU".toHashSet()
        fun add(b: Int, e: Int) {
            if (sentence[b] in vowels) {
                append(sentence, b, e)
            } else {
                append(sentence, b + 1, e)
                append(sentence[b])
            }
            append("ma")
            repeat(index++) { append('a') }
        }
        for (j in sentence.indices) {
            if (sentence[j] != ' ')
                continue
            add(i, j)
            append(' ')
            i = j + 1
        }
        add(i, sentence.length)
    }
}