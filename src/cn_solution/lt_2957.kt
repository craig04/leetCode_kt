package cn_solution

fun removeAlmostEqualCharacters(word: String): Int {
    val n = word.length
    var i = 1
    var ans = 0
    while (i < n) {
        if (word[i] - word[i - 1] in -1..1) {
            i += 2
            ans++
        } else
            i++
    }
    return ans
}