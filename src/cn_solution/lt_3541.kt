package cn_solution

fun maxFreqSum(s: String): Int {
    val cnt = IntArray(26)
    for (c in s)
        cnt[c - 'a']++
    var ans = 0
    for (c in "aeiou") {
        ans = maxOf(ans, cnt[c - 'a'])
        cnt[c - 'a'] = 0
    }
    return ans + cnt.max()
}