package cn_solution

fun answerString(word: String, numFriends: Int): String {
    return if (numFriends == 1) word else word.indices.maxOf {
        word.substring(it, word.length + minOf(0, it - numFriends + 1))
    }
}