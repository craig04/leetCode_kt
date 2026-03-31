package cn_solution

fun sortString(s: String): String {
    val ans = ArrayList<Char>()
    val cnt = IntArray(26)
    for (c in s)
        cnt[c - 'a']++
    while (ans.size != s.length) {
        for (i in 0 until 26)
            if (cnt[i] != 0) {
                ans.add('a' + i)
                cnt[i]--
            }
        for (i in 25 downTo 0) {
            if (cnt[i] != 0) {
                ans.add('a' + i)
                cnt[i]--
            }
        }
    }
    return String(ans.toCharArray())
}