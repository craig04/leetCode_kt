package cn_solution

private fun numberOfSubstrings(s: String): Int {
    val cnt = IntArray(3)
    var ans = 0
    var cat = 0
    var i = 0
    for (j in s.indices) {
        if (++cnt[s[j] - 'a'] == 1)
            cat++
        while (cat == 3)
            if (--cnt[s[i++] - 'a'] == 0)
                cat--
        ans += i
    }
    return ans
}