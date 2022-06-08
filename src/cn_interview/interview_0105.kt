package cn_interview

fun oneEditAway(first: String, second: String): Boolean {
    val diff = first.length - second.length
    if (diff == 0) {
        return first.indices.count { first[it] != second[it] } <= 1
    }
    if (diff != 1 && diff != -1) {
        return false
    }
    val (short, long) = if (diff < 0) Pair(first, second) else Pair(second, first)
    val idx = short.indices.indexOfFirst { short[it] != long[it] }
    return idx == -1 || (idx until short.length).all { short[it] == long[it + 1] }
}