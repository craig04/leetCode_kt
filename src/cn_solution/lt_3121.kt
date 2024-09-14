package cn_solution

fun numberOfSpecialChars(word: String): Int {
    val lower = IntArray(26) { -1 }
    val upper = IntArray(26) { -1 }
    for (i in word.indices) {
        val c = word[i]
        if (c in 'a'..'z')
            lower[c - 'a'] = i
        else if (upper[c - 'A'] == -1)
            upper[c - 'A'] = i
    }
    return lower.indices.count { lower[it] in 0..upper[it] }
}