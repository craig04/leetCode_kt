package cn_solution

fun longestCommonPrefix(strs: Array<String>): String {
    return strs[0].substring(0, (0..200).first { len ->
        strs.any { it.length <= len || it[len] != strs[0][len] }
    })
}