package cn_solution

fun lastNonEmptyString(s: String): String {
    val cnt = IntArray(26)
    val last = IntArray(26) { -1 }
    for (i in s.indices) {
        val c = s[i] - 'a'
        cnt[c]++
        last[c] = i
    }
    val max = cnt.max()
    val idx = cnt.indices.filterTo(ArrayList()) { cnt[it] == max }
    idx.sortBy { last[it] }
    val ans = StringBuilder()
    for (c in idx)
        ans.append(s[last[c]])
    return ans.toString()
}