package cn_solution

fun canConstruct(s: String, k: Int): Boolean {
    val cnt = IntArray(26)
    for (c in s)
        cnt[c - 'a']++
    return k in (maxOf(1, cnt.sumOf { it % 2 })..s.length)
}