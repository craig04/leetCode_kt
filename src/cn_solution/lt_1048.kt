package cn_solution

fun longestStrChain(words: Array<String>): Int {
    words.sortBy { it.length }
    val shortest = words[0].length
    val dp = HashMap<String, Int>()
    return words.fold(1) { result, word ->
        val length = if (word.length == shortest) 1 else
            word.indices.fold(0) { len, i ->
                val sub = "${word.substring(0, i)}${word.substring(i + 1)}"
                maxOf(len, dp[sub] ?: 0)
            } + 1
        dp[word] = length
        maxOf(result, length)
    }
}