package cn_solution

fun isPrefixOfWord(sentence: String, searchWord: String): Int {
    var ptr = 0
    var index = 1
    for (c in sentence) {
        if (c == ' ') {
            ptr = 0
            index++
            continue
        }
        if (ptr != -1 && c == searchWord[ptr]) {
            if (++ptr == searchWord.length)
                return index
        } else {
            ptr = -1
        }
    }
    return -1
}