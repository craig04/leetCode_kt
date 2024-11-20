package cn_solution

fun compressedString(word: String): String {
    val ans = StringBuilder()
    var i = 0
    while (i != word.length) {
        var j = i + 1
        while (j != word.length && j - i < 9 && word[j] == word[i])
            j++
        ans.append(j - i).append(word[i])
        i = j
    }
    return ans.toString()
}