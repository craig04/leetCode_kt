package cn_solution

fun possibleStringCount(word: String): Int {
    val n = word.length
    var i = 0
    var j = 0
    var ans = 0
    while (j != n) {
        while (j != n && word[j] == word[i])
            j++
        ans += j - i - 1
        i = j
    }
    return ans + 1
}