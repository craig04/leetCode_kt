package cn_solution

fun truncateSentence(s: String, k: Int): String {
    var space = 0
    val end = s.indexOfFirst { it == ' ' && ++space == k }
    return s.substring(0, if (end == -1) s.length else end)
}