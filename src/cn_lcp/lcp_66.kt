package cn_lcp

fun minNumBooths(demand: Array<String>): Int {
    val cnt = IntArray(26)
    val day = IntArray(26)
    for (s in demand) {
        day.fill(0)
        for (c in s)
            day[c - 'a']++
        for (i in 0 until 26)
            cnt[i] = maxOf(cnt[i], day[i])
    }
    return cnt.sum()
}