package cn_solution

fun isPrefixString(s: String, words: Array<String>): Boolean {
    var curr = 0
    for (word in words) {
        if (!s.startsWith(word, curr))
            break
        curr += word.length
        if (curr == s.length)
            return true
    }
    return false
}