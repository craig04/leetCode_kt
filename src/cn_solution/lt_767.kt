package cn_solution

fun reorganizeString(s: String): String {
    val cnt = IntArray(26)
    for (c in s)
        cnt[c - 'a']++
    val x = cnt.indices.maxBy { cnt[it] }
    if (cnt[x] > (s.length + 1) / 2)
        return ""
    val ans = CharArray(s.length)
    var i = 0
    repeat(cnt[x]) {
        ans[i] = 'a' + x
        i += 2
    }
    for (y in cnt.indices) {
        if (y != x && cnt[y] > 0)
            repeat(cnt[y]) {
                if (i >= ans.size)
                    i = 1
                ans[i] = 'a' + y
                i += 2
            }
    }
    return String(ans)
}