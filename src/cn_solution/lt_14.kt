package cn_solution

fun longestCommonPrefix(strs: Array<String>): String {
    val result = strs[0].indices.firstOrNull { i ->
        strs.any { it.length <= i || it[i] != strs[0][i] }
    } ?: strs[0].length
    return strs[0].substring(0, result)
}