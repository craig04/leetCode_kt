package cn_solution

private fun validSubstringCount(word1: String, word2: String): Long {
    val f = IntArray(26)
    for (c in word2)
        f[c - 'a']++
    var ans = 0L
    var cnt = f.count { it == 0 }
    var i = 0
    for (j in word1.indices) {
        if (--f[word1[j] - 'a'] == 0)
            cnt++
        while (cnt == 26 && f[word1[i] - 'a'] < 0)
            f[word1[i++] - 'a']++
        if (cnt == 26)
            ans += i + 1
    }
    return ans
}