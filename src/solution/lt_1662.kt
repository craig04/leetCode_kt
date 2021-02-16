package solution

/**
 * Simpler code with higher space & time complexity
 */
@Suppress("FunctionName")
fun arrayStringsAreEqual_simple(word1: Array<String>, word2: Array<String>): Boolean {
    fun Array<String>.reduce() = reduce { acc, s -> acc + s }
    return word1.reduce() == word2.reduce()
}

/**
 * More complicated code with lower space & time complexity
 */
fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    var i1 = 0
    var i2 = 0
    var j1 = 0
    var j2 = 0
    val s1 = word1.size
    val s2 = word2.size
    while (i1 != s1 && i2 != s2) {
        val l1 = word1[i1].length
        val l2 = word2[i1].length
        while (j1 != l1 && j2 != l2) {
            if (word1[i1][j1++] != word2[i2][j2++]) {
                return false
            }
        }
        if (j1 == l1) {
            i1++
            j1 = 0
        }
        if (j2 == l2) {
            i2++
            j2 = 0
        }
    }
    return i1 == s1 && i2 == s2
}