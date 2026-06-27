package cn_solution

fun maximumLengthSubstring(s: String): Int {
    val cnt = IntArray(26)
    var i = 0
    return s.indices.maxOf { j ->
        cnt[s[j] - 'a']++
        while (cnt[s[j] - 'a'] == 3)
            cnt[s[i++] - 'a']--
        j - i + 1
    }
}