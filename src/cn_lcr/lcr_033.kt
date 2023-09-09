package cn_lcr

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    return strs.groupBy { String(it.toCharArray().apply { sort() }) }.map { it.value }
}