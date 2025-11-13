package cn_solution

fun lexPalindromicPermutation(s: String, target: String): String {
    val n = s.length
    val c = CharArray(n) { ' ' }
    val cnt = IntArray(26)
    for (c in s)
        cnt[c - 'a']++
    if (cnt.sumOf { it % 2 } > 1)
        return ""
    var i = 0
    while (i < n / 2) {
        val t = target[i]
        if (cnt[t - 'a'] < 2)
            break
        c[i] = t
        c[n - 1 - i++] = t
        cnt[t - 'a'] -= 2
    }
    if (i == n / 2 && n % 2 == 1) {
        val t = target[i]
        if (cnt[t - 'a'] == 1) {
            cnt[t - 'a'] = 0
            c[i++] = t
        }
    }
    if (i == (n + 1) / 2) {
        val j = (i until n).firstOrNull { c[it] != target[it] }
        if (j == null || c[j] < target[j])
            cnt[c[--i] - 'a'] += 2 - n % 2
        else if (c[j] > target[j])
            return String(c)
    }
    while (i >= 0) {
        val mid = n % 2 == 1 && i == n / 2
        val use = if (mid) 1 else 2
        val t = (target[i] + 1..'z').firstOrNull { cnt[it - 'a'] >= use }
        if (t == null) {
            if (--i >= 0)
                cnt[c[i] - 'a'] += 2
            continue
        }
        cnt[t - 'a'] -= use
        c[i] = t
        c[n - i - 1] = t
        for (t in 'a'..'z') {
            repeat(cnt[t - 'a'] / 2) {
                c[++i] = t
                c[n - i - 1] = t
            }
            if (cnt[t - 'a'] % 2 == 1)
                c[n / 2] = t
        }
        return String(c)
    }
    return ""
}