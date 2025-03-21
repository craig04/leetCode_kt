package cn_solution

fun smallestPalindrome(s: String): String {
    val n = s.length
    val cnt = IntArray(26)
    s.forEach { cnt[it - 'a']++ }
    val ans = CharArray(n)
    var i = 0
    var j = ans.size - 1
    for (t in cnt.indices)
        if (cnt[t] % 2 == 1) {
            ans[n / 2] = 'a' + t
            cnt[t]--
        }
    for (t in cnt.indices) {
        repeat(cnt[t] / 2) {
            ans[i++] = 'a' + t
            ans[j--] = 'a' + t
        }
    }
    return String(ans)
}