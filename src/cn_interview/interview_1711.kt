package cn_interview

fun findClosest(words: Array<String>, word1: String, word2: String): Int {
    var p = -1
    var q = -1
    var result = Int.MAX_VALUE
    for (i in words.indices) {
        if (words[i] == word1)
            p = i
        else if (words[i] == word2)
            q = i
        else
            continue
        if (p != -1 && q != -1)
            result = minOf(result, Math.abs(p - q))
    }
    return result
}