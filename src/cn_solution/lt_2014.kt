package cn_solution

fun longestSubsequenceRepeatedK(s: String, k: Int): String {
    val cnt = IntArray(26)
    for (c in s)
        cnt[c - 'a']++
    val a = ArrayList<Char>()
    for (i in cnt.indices)
        repeat(cnt[i] / k) { a.add('a' + i) }
    a.sort()
    var ans = ""
    val vis = BooleanArray(a.size)
    val str = StringBuilder()
    fun update(): Boolean {
        val diff = str.length - ans.length
        if (diff < 0)
            return false
        if (diff == 0)
            for (i in str.indices)
                if (str[i] > ans[i])
                    break
                else if (str[i] < ans[i])
                    return false
        var i = 0
        var repeat = 0
        for (c in s) {
            if (c == str[i] && ++i == str.length) {
                if (++repeat == k)
                    return true
                i = 0
            }
        }
        return false
    }

    fun dfs(i: Int) {
        if (i == a.size)
            return
        for (j in a.indices) {
            if (vis[j] || (j != 0 && a[j] == a[j - 1] && !vis[j - 1]))
                continue
            str.append(a[j])
            vis[j] = true
            if (update())
                ans = str.toString()
            dfs(i + 1)
            vis[j] = false
            str.deleteCharAt(str.lastIndex)
        }
    }
    dfs(0)
    return ans
}