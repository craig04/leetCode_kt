package cn_solution

fun minDeletion(s: String, k: Int): Int {
    val cnt = IntArray(26)
    s.forEach { cnt[it - 'a']++ }
    cnt.sort()
    return (0 until 26 - k).sumOf { cnt[it] }
}