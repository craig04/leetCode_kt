package cn_solution

fun minOperations(s: String): Int {
    val cnt = s.indices.count { s[it] - '0' == it and 1 }
    return minOf(cnt, s.length - cnt)
}