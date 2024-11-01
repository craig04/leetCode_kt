package cn_solution

fun countKConstraintSubstrings(s: String, k: Int, queries: Array<IntArray>): LongArray {
    val n = s.length
    var i = 0
    val cnt = IntArray(2)
    val pref = LongArray(n + 1)
    val left = IntArray(n) { j ->
        cnt[s[j] - '0']++
        while (cnt.min() > k)
            cnt[s[i++] - '0']--
        pref[j + 1] = pref[j] + j - i + 1
        i
    }
    i = 0
    val right = IntArray(n) { j ->
        while (i != n && left[i] < j)
            i++
        i
    }
    return LongArray(queries.size) {
        val (l, r) = queries[it]
        val t = minOf(right[l], r + 1)
        (t - l + 1L) * (t - l) / 2 + pref[r + 1] - pref[t]
    }
}