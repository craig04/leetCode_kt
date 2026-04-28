package cn_solution

private fun sortVowels(s: String): String {
    val x = 0x104111
    val vowels = ArrayList<Int>()
    val pos = IntArray(26) { -1 }
    val cnt = IntArray(26)
    for (i in s.indices) {
        val c = s[i] - 'a'
        if (1 shl c and x != 0) {
            vowels.add(c)
            if (pos[c] == -1)
                pos[c] = i
            cnt[c]++
        }
    }
    vowels.sortWith { a, b ->
        if (cnt[a] == cnt[b]) pos[a] - pos[b] else cnt[b] - cnt[a]
    }
    val ans = CharArray(s.length)
    var j = 0
    for (i in s.indices) {
        var c = s[i] - 'a'
        if (1 shl c and x != 0)
            c = vowels[j++]
        ans[i] = 'a' + c
    }
    return String(ans)
}