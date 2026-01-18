package cn_solution

fun numOfStrings(patterns: Array<String>, word: String): Int {
    return patterns.count { word.indexOf(it) != -1 }
}