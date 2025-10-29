package cn_solution

fun lexGreaterPermutation(s: String, target: String): String {
    val cnt = IntArray(26)
    s.forEach { cnt[it - 'a']++ }
    val n = s.length
    var i = 0
    val c = target.toCharArray()
    while (i != n - 1) {
        val t = target[i] - 'a'
        if (cnt[t] == 0)
            break
        cnt[t]--
        i++
    }
    while (true) {
        for (t in target[i] + 1..'z') {
            if (cnt[t - 'a'] == 0)
                continue
            cnt[t - 'a']--
            c[i++] = t
            for (x in 'a'..'z')
                repeat(cnt[x - 'a']) { c[i++] = x }
            return String(c)
        }
        if (i == 0)
            break
        cnt[c[--i] - 'a']++
    }
    return ""
}