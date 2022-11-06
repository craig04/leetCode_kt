package cn_solution

fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    var i1 = 0
    var j1 = 0
    var i2 = 0
    var j2 = 0
    while (i1 != word1.size && i2 != word2.size) {
        if (word1[i1][j1] != word2[i2][j2])
            return false
        if (++j1 == word1[i1].length) {
            i1++
            j1 = 0
        }
        if (++j2 == word2[i2].length) {
            i2++
            j2 = 0
        }
    }
    return i1 == word1.size && i2 == word2.size
}
