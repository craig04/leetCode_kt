package cn_solution

fun areOccurrencesEqual(s: String): Boolean {
    val cnt = IntArray(26)
    var any = 0
    for (c in s)
        any = ++cnt[c - 'a']
    return cnt.all { it == 0 || it == any }
}