package cn_solution

fun firstUniqChar(s: String): Int {
    val count = IntArray(26)
    for (c in s) count[c - 'a']++
    return s.indexOfFirst { count[it - 'a'] == 1 }
}