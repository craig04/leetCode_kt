package cn_solution

fun maximumNumberOfStringPairs(words: Array<String>): Int {
    fun hash(a: Char, b: Char) = (a - 'a' + 1) * 26 + (b - 'a' + 1)
    val exist = BooleanArray(26 * 26)
    return words.count {
        val increase = exist[hash(it[0], it[1])]
        exist[hash(it[1], it[0])] = true
        increase
    }
}