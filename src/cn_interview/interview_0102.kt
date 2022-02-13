package cn_interview

fun CheckPermutation(s1: String, s2: String): Boolean {
    fun String.toSortedArray() = toCharArray().apply { sort() }
    return s1.length == s2.length && s1.toSortedArray().contentEquals(s2.toSortedArray())
}