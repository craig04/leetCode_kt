package cn_solution

private fun minSteps(s: String, t: String): Int {
    val cnt = IntArray(26)
    s.forEach { cnt[it - 'a']++ }
    t.forEach { cnt[it - 'a']-- }
    return cnt.sumOf { maxOf(0, it) }
}